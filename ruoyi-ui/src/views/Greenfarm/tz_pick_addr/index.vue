<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="自提点名称" prop="addrName">
        <el-input
          v-model="queryParams.addrName"
          placeholder="请输入自提点名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机" prop="mobile">
        <el-input
          v-model="queryParams.mobile"
          placeholder="请输入手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省份ID" prop="provinceId">
        <el-input
          v-model="queryParams.provinceId"
          placeholder="请输入省份ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省份" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城市ID" prop="cityId">
        <el-input
          v-model="queryParams.cityId"
          placeholder="请输入城市ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区/县ID" prop="areaId">
        <el-input
          v-model="queryParams.areaId"
          placeholder="请输入区/县ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区/县" prop="area">
        <el-input
          v-model="queryParams.area"
          placeholder="请输入区/县"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺id" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入店铺id"
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
          v-hasPermi="['Greenfarm:tz_pick_addr:add']"
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
          v-hasPermi="['Greenfarm:tz_pick_addr:edit']"
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
          v-hasPermi="['Greenfarm:tz_pick_addr:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_pick_addr:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_pick_addrList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="addrId" />
      <el-table-column label="自提点名称" align="center" prop="addrName" />
      <el-table-column label="地址" align="center" prop="addr" />
      <el-table-column label="手机" align="center" prop="mobile" />
      <el-table-column label="省份ID" align="center" prop="provinceId" />
      <el-table-column label="省份" align="center" prop="province" />
      <el-table-column label="城市ID" align="center" prop="cityId" />
      <el-table-column label="城市" align="center" prop="city" />
      <el-table-column label="区/县ID" align="center" prop="areaId" />
      <el-table-column label="区/县" align="center" prop="area" />
      <el-table-column label="店铺id" align="center" prop="shopId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_pick_addr:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_pick_addr:remove']"
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

    <!-- 添加或修改用户配送地址对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="自提点名称" prop="addrName">
          <el-input v-model="form.addrName" placeholder="请输入自提点名称" />
        </el-form-item>
        <el-form-item label="地址" prop="addr">
          <el-input v-model="form.addr" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="手机" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入手机" />
        </el-form-item>
        <el-form-item label="省份ID" prop="provinceId">
          <el-input v-model="form.provinceId" placeholder="请输入省份ID" />
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="form.province" placeholder="请输入省份" />
        </el-form-item>
        <el-form-item label="城市ID" prop="cityId">
          <el-input v-model="form.cityId" placeholder="请输入城市ID" />
        </el-form-item>
        <el-form-item label="城市" prop="city">
          <el-input v-model="form.city" placeholder="请输入城市" />
        </el-form-item>
        <el-form-item label="区/县ID" prop="areaId">
          <el-input v-model="form.areaId" placeholder="请输入区/县ID" />
        </el-form-item>
        <el-form-item label="区/县" prop="area">
          <el-input v-model="form.area" placeholder="请输入区/县" />
        </el-form-item>
        <el-form-item label="店铺id" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺id" />
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
import { listTz_pick_addr, getTz_pick_addr, delTz_pick_addr, addTz_pick_addr, updateTz_pick_addr } from "@/api/Greenfarm/tz_pick_addr";

export default {
  name: "Tz_pick_addr",
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
      // 用户配送地址表格数据
      tz_pick_addrList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        addrName: null,
        addr: null,
        mobile: null,
        provinceId: null,
        province: null,
        cityId: null,
        city: null,
        areaId: null,
        area: null,
        shopId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户配送地址列表 */
    getList() {
      this.loading = true;
      listTz_pick_addr(this.queryParams).then(response => {
        this.tz_pick_addrList = response.rows;
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
        addrId: null,
        addrName: null,
        addr: null,
        mobile: null,
        provinceId: null,
        province: null,
        cityId: null,
        city: null,
        areaId: null,
        area: null,
        shopId: null
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
      this.ids = selection.map(item => item.addrId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户配送地址";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const addrId = row.addrId || this.ids
      getTz_pick_addr(addrId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户配送地址";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.addrId != null) {
            updateTz_pick_addr(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_pick_addr(this.form).then(response => {
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
      const addrIds = row.addrId || this.ids;
      this.$modal.confirm('是否确认删除用户配送地址编号为"' + addrIds + '"的数据项？').then(function() {
        return delTz_pick_addr(addrIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_pick_addr/export', {
        ...this.queryParams
      }, `tz_pick_addr_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
