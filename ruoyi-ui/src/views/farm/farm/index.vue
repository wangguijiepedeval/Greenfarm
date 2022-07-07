<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="farmname">
        <el-input
          v-model="queryParams.farmname"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="farmphoto">
        <el-input
          v-model="queryParams.farmphoto"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="农场主" prop="merchantid">
        <el-input
          v-model="queryParams.merchantid"
          placeholder="请输入农场主"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="farmaddress">
        <el-input
          v-model="queryParams.farmaddress"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="租金" prop="rent">
        <el-input
          v-model="queryParams.rent"
          placeholder="请输入租金"
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
          v-hasPermi="['farm:farm:add']"
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
          v-hasPermi="['farm:farm:edit']"
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
          v-hasPermi="['farm:farm:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['farm:farm:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="farmList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="farmid" />
      <el-table-column label="${comment}" align="center" prop="farmname" />
      <el-table-column label="${comment}" align="center" prop="farmphoto" />
      <el-table-column label="农场主" align="center" prop="merchantid" />
      <el-table-column label="${comment}" align="center" prop="farmaddress" />
      <el-table-column label="农场标识，0不可租，1可租" align="center" prop="farmstatus" />
      <el-table-column label="租金" align="center" prop="rent" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['farm:farm:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['farm:farm:remove']"
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

    <!-- 添加或修改farm管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="农场ID" prop="farmid">
          <el-input v-model="form.farmid" placeholder="请输入农场ID" />
        </el-form-item>
        <el-form-item label="农场名" prop="farmname">
          <el-input v-model="form.farmname" placeholder="请输入农场名" />
        </el-form-item>
        <el-form-item label="农场电话" prop="farmphoto">
          <el-input v-model="form.farmphoto" placeholder="请输入农场电话" />
        </el-form-item>
        <el-form-item label="农场主" prop="merchantid">
          <el-input v-model="form.merchantid" placeholder="请输入农场主" />
        </el-form-item>
        <el-form-item label="农场地址" prop="farmaddress">
          <el-input v-model="form.farmaddress" placeholder="请输入农场地址" />
        </el-form-item>
        <el-form-item label="租金" prop="rent">
          <el-input v-model="form.rent" placeholder="请输入租金" />
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
import { listFarm, getFarm, delFarm, addFarm, updateFarm } from "@/api/farm/farm";

export default {
  name: "Farm",
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
      // farm管理表格数据
      farmList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        farmname: null,
        farmphoto: null,
        merchantid: null,
        farmaddress: null,
        farmstatus: null,
        rent: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        farmname: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        merchantid: [
          { required: true, message: "农场主不能为空", trigger: "blur" }
        ],
        farmaddress: [
          { required: true, message: "$comment不能为空", trigger: "blur" }
        ],
        farmstatus: [
          { required: true, message: "农场标识，0不可租，1可租不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询farm管理列表 */
    getList() {
      this.loading = true;
      listFarm(this.queryParams).then(response => {
        this.farmList = response.rows;
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
        farmid: null,
        farmname: null,
        farmphoto: null,
        merchantid: null,
        farmaddress: null,
        farmstatus: 0,
        rent: null,
        updateTime: null,
        createTime: null
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
      this.ids = selection.map(item => item.farmid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加farm管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const farmid = row.farmid || this.ids
      getFarm(farmid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改farm管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.farmid != null) {
            updateFarm(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.farmid=Date.now(); //如果没有填写编号，将自动获取时间戳
            addFarm(this.form).then(response => {
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
      const farmids = row.farmid || this.ids;
      this.$modal.confirm('是否确认删除farm管理编号为"' + farmids + '"的数据项？').then(function() {
        return delFarm(farmids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('farm/farm/export', {
        ...this.queryParams
      }, `farm_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
