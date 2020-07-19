<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="客户银行卡号" prop="materialBankCard">
      <el-input v-model="dataForm.materialBankCard" placeholder="客户银行卡号"></el-input>
    </el-form-item>
    <el-form-item label="客和银行卡对应的名字" prop="materialBankCardUser">
      <el-input v-model="dataForm.materialBankCardUser" placeholder="客和银行卡对应的名字"></el-input>
    </el-form-item>
    <el-form-item label="被保险人的id（通过被保险人的id获取被保险人的姓名身份证号码如果是公司的车辆这里就是获取公司的名称和公司的组织机构代码）" prop="insuredId">
      <el-input v-model="dataForm.insuredId" placeholder="被保险人的id（通过被保险人的id获取被保险人的姓名身份证号码如果是公司的车辆这里就是获取公司的名称和公司的组织机构代码）"></el-input>
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
          materialId: 0,
          materialBankCard: '',
          materialBankCardUser: '',
          insuredId: ''
        },
        dataRule: {
          materialBankCard: [
            { required: true, message: '客户银行卡号不能为空', trigger: 'blur' }
          ],
          materialBankCardUser: [
            { required: true, message: '客和银行卡对应的名字不能为空', trigger: 'blur' }
          ],
          insuredId: [
            { required: true, message: '被保险人的id（通过被保险人的id获取被保险人的姓名身份证号码如果是公司的车辆这里就是获取公司的名称和公司的组织机构代码）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.materialId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.materialId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/material/info/${this.dataForm.materialId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.materialBankCard = data.material.materialBankCard
                this.dataForm.materialBankCardUser = data.material.materialBankCardUser
                this.dataForm.insuredId = data.material.insuredId
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
              url: this.$http.adornUrl(`/generator/material/${!this.dataForm.materialId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'materialId': this.dataForm.materialId || undefined,
                'materialBankCard': this.dataForm.materialBankCard,
                'materialBankCardUser': this.dataForm.materialBankCardUser,
                'insuredId': this.dataForm.insuredId
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
