<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="记录人（这里指客户打电话接电话的人）" prop="claimFormRecorder">
      <el-input v-model="dataForm.claimFormRecorder" placeholder="记录人（这里指客户打电话接电话的人）"></el-input>
    </el-form-item>
    <el-form-item label="事故原因" prop="claimFormCause">
      <el-input v-model="dataForm.claimFormCause" placeholder="事故原因"></el-input>
    </el-form-item>
    <el-form-item label="事故地点" prop="claimFormSite">
      <el-input v-model="dataForm.claimFormSite" placeholder="事故地点"></el-input>
    </el-form-item>
    <el-form-item label="险种id" prop="insuranceInserIncludeId">
      <el-input v-model="dataForm.insuranceInserIncludeId" placeholder="险种id"></el-input>
    </el-form-item>
    <el-form-item label="事故图片" prop="claimFormPicture">
      <el-input v-model="dataForm.claimFormPicture" placeholder="事故图片"></el-input>
    </el-form-item>
    <el-form-item label="勘探人" prop="claimFormExploration">
      <el-input v-model="dataForm.claimFormExploration" placeholder="勘探人"></el-input>
    </el-form-item>
    <el-form-item label="勘探人手机号" prop="claimFormExplorationPhone">
      <el-input v-model="dataForm.claimFormExplorationPhone" placeholder="勘探人手机号"></el-input>
    </el-form-item>
    <el-form-item label="定损id" prop="lossAssessmentId">
      <el-input v-model="dataForm.lossAssessmentId" placeholder="定损id"></el-input>
    </el-form-item>
    <el-form-item label="理赔资料id" prop="materialId">
      <el-input v-model="dataForm.materialId" placeholder="理赔资料id"></el-input>
    </el-form-item>
    <el-form-item label="赔款id" prop="indemnityId">
      <el-input v-model="dataForm.indemnityId" placeholder="赔款id"></el-input>
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
          claimFormId: 0,
          claimFormRecorder: '',
          claimFormCause: '',
          claimFormSite: '',
          insuranceInserIncludeId: '',
          claimFormPicture: '',
          claimFormExploration: '',
          claimFormExplorationPhone: '',
          lossAssessmentId: '',
          materialId: '',
          indemnityId: ''
        },
        dataRule: {
          claimFormRecorder: [
            { required: true, message: '记录人（这里指客户打电话接电话的人）不能为空', trigger: 'blur' }
          ],
          claimFormCause: [
            { required: true, message: '事故原因不能为空', trigger: 'blur' }
          ],
          claimFormSite: [
            { required: true, message: '事故地点不能为空', trigger: 'blur' }
          ],
          insuranceInserIncludeId: [
            { required: true, message: '险种id不能为空', trigger: 'blur' }
          ],
          claimFormPicture: [
            { required: true, message: '事故图片不能为空', trigger: 'blur' }
          ],
          claimFormExploration: [
            { required: true, message: '勘探人不能为空', trigger: 'blur' }
          ],
          claimFormExplorationPhone: [
            { required: true, message: '勘探人手机号不能为空', trigger: 'blur' }
          ],
          lossAssessmentId: [
            { required: true, message: '定损id不能为空', trigger: 'blur' }
          ],
          materialId: [
            { required: true, message: '理赔资料id不能为空', trigger: 'blur' }
          ],
          indemnityId: [
            { required: true, message: '赔款id不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.claimFormId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.claimFormId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/form/info/${this.dataForm.claimFormId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.claimFormRecorder = data.form.claimFormRecorder
                this.dataForm.claimFormCause = data.form.claimFormCause
                this.dataForm.claimFormSite = data.form.claimFormSite
                this.dataForm.insuranceInserIncludeId = data.form.insuranceInserIncludeId
                this.dataForm.claimFormPicture = data.form.claimFormPicture
                this.dataForm.claimFormExploration = data.form.claimFormExploration
                this.dataForm.claimFormExplorationPhone = data.form.claimFormExplorationPhone
                this.dataForm.lossAssessmentId = data.form.lossAssessmentId
                this.dataForm.materialId = data.form.materialId
                this.dataForm.indemnityId = data.form.indemnityId
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
              url: this.$http.adornUrl(`/generator/form/${!this.dataForm.claimFormId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'claimFormId': this.dataForm.claimFormId || undefined,
                'claimFormRecorder': this.dataForm.claimFormRecorder,
                'claimFormCause': this.dataForm.claimFormCause,
                'claimFormSite': this.dataForm.claimFormSite,
                'insuranceInserIncludeId': this.dataForm.insuranceInserIncludeId,
                'claimFormPicture': this.dataForm.claimFormPicture,
                'claimFormExploration': this.dataForm.claimFormExploration,
                'claimFormExplorationPhone': this.dataForm.claimFormExplorationPhone,
                'lossAssessmentId': this.dataForm.lossAssessmentId,
                'materialId': this.dataForm.materialId,
                'indemnityId': this.dataForm.indemnityId
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
