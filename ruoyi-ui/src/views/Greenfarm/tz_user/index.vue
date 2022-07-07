<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户昵称" prop="nickName">
        <el-input
          v-model="queryParams.nickName"
          placeholder="请输入用户昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="真实姓名" prop="realName">
        <el-input
          v-model="queryParams.realName"
          placeholder="请输入真实姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户邮箱" prop="userMail">
        <el-input
          v-model="queryParams.userMail"
          placeholder="请输入用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="登录密码" prop="loginPassword">
        <el-input
          v-model="queryParams.loginPassword"
          placeholder="请输入登录密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付密码" prop="payPassword">
        <el-input
          v-model="queryParams.payPassword"
          placeholder="请输入支付密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号码" prop="userMobile">
        <el-input
          v-model="queryParams.userMobile"
          placeholder="请输入手机号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改时间" prop="modifyTime">
        <el-date-picker clearable
          v-model="queryParams.modifyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择修改时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="注册时间" prop="userRegtime">
        <el-date-picker clearable
          v-model="queryParams.userRegtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择注册时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="注册IP" prop="userRegip">
        <el-input
          v-model="queryParams.userRegip"
          placeholder="请输入注册IP"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最后登录时间" prop="userLasttime">
        <el-date-picker clearable
          v-model="queryParams.userLasttime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最后登录时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最后登录IP" prop="userLastip">
        <el-input
          v-model="queryParams.userLastip"
          placeholder="请输入最后登录IP"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="例如：2009-11-27" prop="birthDate">
        <el-input
          v-model="queryParams.birthDate"
          placeholder="请输入例如：2009-11-27"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="头像图片路径" prop="pic">
        <el-input
          v-model="queryParams.pic"
          placeholder="请输入头像图片路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户积分" prop="score">
        <el-input
          v-model="queryParams.score"
          placeholder="请输入用户积分"
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
          v-hasPermi="['Greenfarm:tz_user:add']"
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
          v-hasPermi="['Greenfarm:tz_user:edit']"
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
          v-hasPermi="['Greenfarm:tz_user:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_user:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_userList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="userId" />
      <el-table-column label="用户昵称" align="center" prop="nickName" />
      <el-table-column label="真实姓名" align="center" prop="realName" />
      <el-table-column label="用户邮箱" align="center" prop="userMail" />
      <el-table-column label="登录密码" align="center" prop="loginPassword" />
      <el-table-column label="支付密码" align="center" prop="payPassword" />
      <el-table-column label="手机号码" align="center" prop="userMobile" />
      <el-table-column label="修改时间" align="center" prop="modifyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="注册时间" align="center" prop="userRegtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.userRegtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="注册IP" align="center" prop="userRegip" />
      <el-table-column label="最后登录时间" align="center" prop="userLasttime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.userLasttime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后登录IP" align="center" prop="userLastip" />
      <el-table-column label="备注" align="center" prop="userMemo" />
      <el-table-column label="M(男) or F(女)" align="center" prop="sex" />
      <el-table-column label="例如：2009-11-27" align="center" prop="birthDate" />
      <el-table-column label="头像图片路径" align="center" prop="pic" />
      <el-table-column label="状态 1 正常 0 无效" align="center" prop="status" />
      <el-table-column label="用户积分" align="center" prop="score" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_user:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_user:remove']"
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

    <!-- 添加或修改用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户昵称" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入用户昵称" />
        </el-form-item>
        <el-form-item label="真实姓名" prop="realName">
          <el-input v-model="form.realName" placeholder="请输入真实姓名" />
        </el-form-item>
        <el-form-item label="用户邮箱" prop="userMail">
          <el-input v-model="form.userMail" placeholder="请输入用户邮箱" />
        </el-form-item>
        <el-form-item label="登录密码" prop="loginPassword">
          <el-input v-model="form.loginPassword" placeholder="请输入登录密码" />
        </el-form-item>
        <el-form-item label="支付密码" prop="payPassword">
          <el-input v-model="form.payPassword" placeholder="请输入支付密码" />
        </el-form-item>
        <el-form-item label="手机号码" prop="userMobile">
          <el-input v-model="form.userMobile" placeholder="请输入手机号码" />
        </el-form-item>
        <el-form-item label="修改时间" prop="modifyTime">
          <el-date-picker clearable
            v-model="form.modifyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择修改时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="注册时间" prop="userRegtime">
          <el-date-picker clearable
            v-model="form.userRegtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择注册时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="注册IP" prop="userRegip">
          <el-input v-model="form.userRegip" placeholder="请输入注册IP" />
        </el-form-item>
        <el-form-item label="最后登录时间" prop="userLasttime">
          <el-date-picker clearable
            v-model="form.userLasttime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后登录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后登录IP" prop="userLastip">
          <el-input v-model="form.userLastip" placeholder="请输入最后登录IP" />
        </el-form-item>
        <el-form-item label="备注" prop="userMemo">
          <el-input v-model="form.userMemo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="例如：2009-11-27" prop="birthDate">
          <el-input v-model="form.birthDate" placeholder="请输入例如：2009-11-27" />
        </el-form-item>
        <el-form-item label="头像图片路径" prop="pic">
          <el-input v-model="form.pic" placeholder="请输入头像图片路径" />
        </el-form-item>
        <el-form-item label="用户积分" prop="score">
          <el-input v-model="form.score" placeholder="请输入用户积分" />
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
import { listTz_user, getTz_user, delTz_user, addTz_user, updateTz_user } from "@/api/Greenfarm/tz_user";

export default {
  name: "Tz_user",
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
      // 用户表格数据
      tz_userList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nickName: null,
        realName: null,
        userMail: null,
        loginPassword: null,
        payPassword: null,
        userMobile: null,
        modifyTime: null,
        userRegtime: null,
        userRegip: null,
        userLasttime: null,
        userLastip: null,
        userMemo: null,
        sex: null,
        birthDate: null,
        pic: null,
        status: null,
        score: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        modifyTime: [
          { required: true, message: "修改时间不能为空", trigger: "blur" }
        ],
        userRegtime: [
          { required: true, message: "注册时间不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态 1 正常 0 无效不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户列表 */
    getList() {
      this.loading = true;
      listTz_user(this.queryParams).then(response => {
        this.tz_userList = response.rows;
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
        userId: null,
        nickName: null,
        realName: null,
        userMail: null,
        loginPassword: null,
        payPassword: null,
        userMobile: null,
        modifyTime: null,
        userRegtime: null,
        userRegip: null,
        userLasttime: null,
        userLastip: null,
        userMemo: null,
        sex: null,
        birthDate: null,
        pic: null,
        status: 0,
        score: null
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
      this.ids = selection.map(item => item.userId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.userId || this.ids
      getTz_user(userId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userId != null) {
            updateTz_user(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_user(this.form).then(response => {
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
      const userIds = row.userId || this.ids;
      this.$modal.confirm('是否确认删除用户编号为"' + userIds + '"的数据项？').then(function() {
        return delTz_user(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_user/export', {
        ...this.queryParams
      }, `tz_user_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
