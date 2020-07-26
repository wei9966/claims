<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="登录用户名" prop="insuranceLoginUser">
      <el-input v-model="dataForm.insuranceLoginUser" placeholder="登录用户名"></el-input>
    </el-form-item>
    <el-form-item label="登录密码" prop="insuranceLoginPassword">
      <el-input v-model="dataForm.insuranceLoginPassword" placeholder="登录密码"></el-input>
    </el-form-item>
    <el-form-item label="角色id" prop="roleId">
      <el-input v-model="dataForm.roleId" placeholder="角色id"></el-input>
    </el-form-item>
    <el-form-item label="登录手机号" prop="insuranceLoginPhone">
      <el-input v-model="dataForm.insuranceLoginPhone" placeholder="登录手机号"></el-input>
    </el-form-item>
    <el-form-item label="登录邮箱" prop="insuranceLoginEmai">
      <el-input v-model="dataForm.insuranceLoginEmai" placeholder="登录邮箱"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          insuranceLoginId: 0,
          insuranceLoginUser: '',
          insuranceLoginPassword: '',
          roleId: '',
          insuranceLoginPhone: '',
          insuranceLoginEmai: ''
        },
        dataRule: {
          insuranceLoginUser: [
            { required: true, message: '登录用户名不能为空', trigger: 'blur' }
          ],
          insuranceLoginPassword: [
            { required: true, message: '登录密码不能为空', trigger: 'blur' }
          ],
          roleId: [
            { required: true, message: '角色id不能为空', trigger: 'blur' }
          ],
          insuranceLoginPhone: [
            { required: true, message: '登录手机号不能为空', trigger: 'blur' }
          ],
          insuranceLoginEmai: [
            { required: true, message: '登录邮箱不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.insuranceLoginId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.insuranceLoginId) {
            this.$http({
              url: this.$http.adornUrl(`/insurance/login/info/${this.dataForm.insuranceLoginId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.insuranceLoginUser = data.login.insuranceLoginUser
                this.dataForm.insuranceLoginPassword = data.login.insuranceLoginPassword
                this.dataForm.roleId = data.login.roleId
                this.dataForm.insuranceLoginPhone = data.login.insuranceLoginPhone
                this.dataForm.insuranceLoginEmai = data.login.insuranceLoginEmai
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/insurance/login/${!this.dataForm.insuranceLoginId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'insuranceLoginId': this.dataForm.insuranceLoginId || undefined,
                'insuranceLoginUser': this.dataForm.insuranceLoginUser,
                'insuranceLoginPassword': this.dataForm.insuranceLoginPassword,
                'roleId': this.dataForm.roleId,
                'insuranceLoginPhone': this.dataForm.insuranceLoginPhone,
                'insuranceLoginEmai': this.dataForm.insuranceLoginEmai
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
