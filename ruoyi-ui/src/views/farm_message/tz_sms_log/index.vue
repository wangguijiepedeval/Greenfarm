<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号码" prop="userPhone">
        <el-input
          v-model="queryParams.userPhone"
          placeholder="请输入手机号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机验证码" prop="mobileCode">
        <el-input
          v-model="queryParams.mobileCode"
          placeholder="请输入手机验证码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发送时间" prop="recDate">
        <el-date-picker clearable
          v-model="queryParams.recDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发送时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="发送短信返回码" prop="responseCode">
        <el-input
          v-model="queryParams.responseCode"
          placeholder="请输入发送短信返回码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['Greenfarm:tz_sms_log:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['Greenfarm:tz_sms_log:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['Greenfarm:tz_sms_log:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_sms_log:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_sms_logList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="手机号码" align="center" prop="userPhone" />
      <el-table-column label="短信内容" align="center" prop="content" />
      <el-table-column label="手机验证码" align="center" prop="mobileCode" />
      <el-table-column label="短信类型  1:注册  2:验证" align="center" prop="type" />
      <el-table-column label="发送时间" align="center" prop="recDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发送短信返回码" align="center" prop="responseCode" />
      <el-table-column label="状态  1:有效  0：失效" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_sms_log:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_sms_log:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改短信记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="手机号码" prop="userPhone">
          <el-input v-model="form.userPhone" placeholder="请输入手机号码" />
        </el-form-item>
        <el-form-item label="短信内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="手机验证码" prop="mobileCode">
          <el-input v-model="form.mobileCode" placeholder="请输入手机验证码" />
        </el-form-item>
        <el-form-item label="发送时间" prop="recDate">
          <el-date-picker clearable
            v-model="form.recDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发送时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发送短信返回码" prop="responseCode">
          <el-input v-model="form.responseCode" placeholder="请输入发送短信返回码" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTz_sms_log, getTz_sms_log, delTz_sms_log, addTz_sms_log, updateTz_sms_log } from "@/api/Greenfarm/tz_sms_log";

export default {
  name: "Tz_sms_log",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 短信记录表格数据
      tz_sms_logList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        userPhone: null,
        content: null,
        mobileCode: null,
        type: null,
        recDate: null,
        responseCode: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userPhone: [
          { required: true, message: "手机号码不能为空", trigger: "blur" }
        ],
        content: [
          { required: true, message: "短信内容不能为空", trigger: "blur" }
        ],
        mobileCode: [
          { required: true, message: "手机验证码不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "短信类型  1:注册  2:验证不能为空", trigger: "change" }
        ],
        recDate: [
          { required: true, message: "发送时间不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态  1:有效  0：失效不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询短信记录列表 */
    getList() {
      this.loading = true;
      listTz_sms_log(this.queryParams).then(response => {
        this.tz_sms_logList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userId: null,
        userPhone: null,
        content: null,
        mobileCode: null,
        type: null,
        recDate: null,
        responseCode: null,
        status: 0
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加短信记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTz_sms_log(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改短信记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTz_sms_log(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_sms_log(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除短信记录编号为"' + ids + '"的数据项？').then(function() {
        return delTz_sms_log(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_sms_log/export', {
        ...this.queryParams
      }, `tz_sms_log_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
