<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店长用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入店长用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺简介(可修改)" prop="intro">
        <el-input
          v-model="queryParams.intro"
          placeholder="请输入店铺简介(可修改)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺公告(可修改)" prop="shopNotice">
        <el-input
          v-model="queryParams.shopNotice"
          placeholder="请输入店铺公告(可修改)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺行业(餐饮、生鲜果蔬、鲜花等)" prop="shopIndustry">
        <el-input
          v-model="queryParams.shopIndustry"
          placeholder="请输入店铺行业(餐饮、生鲜果蔬、鲜花等)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店长" prop="shopOwner">
        <el-input
          v-model="queryParams.shopOwner"
          placeholder="请输入店长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺绑定的手机(登录账号：唯一)" prop="mobile">
        <el-input
          v-model="queryParams.mobile"
          placeholder="请输入店铺绑定的手机(登录账号：唯一)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺联系电话" prop="tel">
        <el-input
          v-model="queryParams.tel"
          placeholder="请输入店铺联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在纬度(可修改)" prop="shopLat">
        <el-input
          v-model="queryParams.shopLat"
          placeholder="请输入店铺所在纬度(可修改)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在经度(可修改)" prop="shopLng">
        <el-input
          v-model="queryParams.shopLng"
          placeholder="请输入店铺所在经度(可修改)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺详细地址" prop="shopAddress">
        <el-input
          v-model="queryParams.shopAddress"
          placeholder="请输入店铺详细地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在省份" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入店铺所在省份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在城市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入店铺所在城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺所在区域" prop="area">
        <el-input
          v-model="queryParams.area"
          placeholder="请输入店铺所在区域"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺省市区代码，用于回显" prop="pcaCode">
        <el-input
          v-model="queryParams.pcaCode"
          placeholder="请输入店铺省市区代码，用于回显"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺logo(可修改)" prop="shopLogo">
        <el-input
          v-model="queryParams.shopLogo"
          placeholder="请输入店铺logo(可修改)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每天营业时间段(可修改)" prop="openTime">
        <el-input
          v-model="queryParams.openTime"
          placeholder="请输入每天营业时间段(可修改)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="固定运费" prop="fixedFreight">
        <el-input
          v-model="queryParams.fixedFreight"
          placeholder="请输入固定运费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="满X包邮" prop="fullFreeShipping">
        <el-input
          v-model="queryParams.fullFreeShipping"
          placeholder="请输入满X包邮"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分销开关(0:开启 1:关闭)" prop="isDistribution">
        <el-input
          v-model="queryParams.isDistribution"
          placeholder="请输入分销开关(0:开启 1:关闭)"
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
          v-hasPermi="['Greenfarm:tz_shop_detail:add']"
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
          v-hasPermi="['Greenfarm:tz_shop_detail:edit']"
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
          v-hasPermi="['Greenfarm:tz_shop_detail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_shop_detail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_shop_detailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="店铺id" align="center" prop="shopId" />
      <el-table-column label="店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一" align="center" prop="shopName" />
      <el-table-column label="店长用户id" align="center" prop="userId" />
      <el-table-column label="店铺类型" align="center" prop="shopType" />
      <el-table-column label="店铺简介(可修改)" align="center" prop="intro" />
      <el-table-column label="店铺公告(可修改)" align="center" prop="shopNotice" />
      <el-table-column label="店铺行业(餐饮、生鲜果蔬、鲜花等)" align="center" prop="shopIndustry" />
      <el-table-column label="店长" align="center" prop="shopOwner" />
      <el-table-column label="店铺绑定的手机(登录账号：唯一)" align="center" prop="mobile" />
      <el-table-column label="店铺联系电话" align="center" prop="tel" />
      <el-table-column label="店铺所在纬度(可修改)" align="center" prop="shopLat" />
      <el-table-column label="店铺所在经度(可修改)" align="center" prop="shopLng" />
      <el-table-column label="店铺详细地址" align="center" prop="shopAddress" />
      <el-table-column label="店铺所在省份" align="center" prop="province" />
      <el-table-column label="店铺所在城市" align="center" prop="city" />
      <el-table-column label="店铺所在区域" align="center" prop="area" />
      <el-table-column label="店铺省市区代码，用于回显" align="center" prop="pcaCode" />
      <el-table-column label="店铺logo(可修改)" align="center" prop="shopLogo" />
      <el-table-column label="店铺相册" align="center" prop="shopPhotos" />
      <el-table-column label="每天营业时间段(可修改)" align="center" prop="openTime" />
      <el-table-column label="店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改" align="center" prop="shopStatus" />
      <el-table-column label="0:商家承担运费; 1:买家承担运费" align="center" prop="transportType" />
      <el-table-column label="固定运费" align="center" prop="fixedFreight" />
      <el-table-column label="满X包邮" align="center" prop="fullFreeShipping" />
      <el-table-column label="分销开关(0:开启 1:关闭)" align="center" prop="isDistribution" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_shop_detail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_shop_detail:remove']"
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

    <!-- 添加或修改商家管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一" />
        </el-form-item>
        <el-form-item label="店长用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入店长用户id" />
        </el-form-item>
        <el-form-item label="店铺简介(可修改)" prop="intro">
          <el-input v-model="form.intro" placeholder="请输入店铺简介(可修改)" />
        </el-form-item>
        <el-form-item label="店铺公告(可修改)" prop="shopNotice">
          <el-input v-model="form.shopNotice" placeholder="请输入店铺公告(可修改)" />
        </el-form-item>
        <el-form-item label="店铺行业(餐饮、生鲜果蔬、鲜花等)" prop="shopIndustry">
          <el-input v-model="form.shopIndustry" placeholder="请输入店铺行业(餐饮、生鲜果蔬、鲜花等)" />
        </el-form-item>
        <el-form-item label="店长" prop="shopOwner">
          <el-input v-model="form.shopOwner" placeholder="请输入店长" />
        </el-form-item>
        <el-form-item label="店铺绑定的手机(登录账号：唯一)" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入店铺绑定的手机(登录账号：唯一)" />
        </el-form-item>
        <el-form-item label="店铺联系电话" prop="tel">
          <el-input v-model="form.tel" placeholder="请输入店铺联系电话" />
        </el-form-item>
        <el-form-item label="店铺所在纬度(可修改)" prop="shopLat">
          <el-input v-model="form.shopLat" placeholder="请输入店铺所在纬度(可修改)" />
        </el-form-item>
        <el-form-item label="店铺所在经度(可修改)" prop="shopLng">
          <el-input v-model="form.shopLng" placeholder="请输入店铺所在经度(可修改)" />
        </el-form-item>
        <el-form-item label="店铺详细地址" prop="shopAddress">
          <el-input v-model="form.shopAddress" placeholder="请输入店铺详细地址" />
        </el-form-item>
        <el-form-item label="店铺所在省份" prop="province">
          <el-input v-model="form.province" placeholder="请输入店铺所在省份" />
        </el-form-item>
        <el-form-item label="店铺所在城市" prop="city">
          <el-input v-model="form.city" placeholder="请输入店铺所在城市" />
        </el-form-item>
        <el-form-item label="店铺所在区域" prop="area">
          <el-input v-model="form.area" placeholder="请输入店铺所在区域" />
        </el-form-item>
        <el-form-item label="店铺省市区代码，用于回显" prop="pcaCode">
          <el-input v-model="form.pcaCode" placeholder="请输入店铺省市区代码，用于回显" />
        </el-form-item>
        <el-form-item label="店铺logo(可修改)" prop="shopLogo">
          <el-input v-model="form.shopLogo" placeholder="请输入店铺logo(可修改)" />
        </el-form-item>
        <el-form-item label="店铺相册" prop="shopPhotos">
          <el-input v-model="form.shopPhotos" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="每天营业时间段(可修改)" prop="openTime">
          <el-input v-model="form.openTime" placeholder="请输入每天营业时间段(可修改)" />
        </el-form-item>
        <el-form-item label="固定运费" prop="fixedFreight">
          <el-input v-model="form.fixedFreight" placeholder="请输入固定运费" />
        </el-form-item>
        <el-form-item label="满X包邮" prop="fullFreeShipping">
          <el-input v-model="form.fullFreeShipping" placeholder="请输入满X包邮" />
        </el-form-item>
        <el-form-item label="分销开关(0:开启 1:关闭)" prop="isDistribution">
          <el-input v-model="form.isDistribution" placeholder="请输入分销开关(0:开启 1:关闭)" />
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
import { listTz_shop_detail, getTz_shop_detail, delTz_shop_detail, addTz_shop_detail, updateTz_shop_detail } from "@/api/Greenfarm/tz_shop_detail";

export default {
  name: "Tz_shop_detail",
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
      // 商家管理表格数据
      tz_shop_detailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopName: null,
        userId: null,
        shopType: null,
        intro: null,
        shopNotice: null,
        shopIndustry: null,
        shopOwner: null,
        mobile: null,
        tel: null,
        shopLat: null,
        shopLng: null,
        shopAddress: null,
        province: null,
        city: null,
        area: null,
        pcaCode: null,
        shopLogo: null,
        shopPhotos: null,
        openTime: null,
        shopStatus: null,
        transportType: null,
        fixedFreight: null,
        fullFreeShipping: null,
        isDistribution: null
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
    /** 查询商家管理列表 */
    getList() {
      this.loading = true;
      listTz_shop_detail(this.queryParams).then(response => {
        this.tz_shop_detailList = response.rows;
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
        shopId: null,
        shopName: null,
        userId: null,
        shopType: null,
        intro: null,
        shopNotice: null,
        shopIndustry: null,
        shopOwner: null,
        mobile: null,
        tel: null,
        shopLat: null,
        shopLng: null,
        shopAddress: null,
        province: null,
        city: null,
        area: null,
        pcaCode: null,
        shopLogo: null,
        shopPhotos: null,
        openTime: null,
        shopStatus: 0,
        transportType: null,
        fixedFreight: null,
        fullFreeShipping: null,
        createTime: null,
        updateTime: null,
        isDistribution: null
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
      this.ids = selection.map(item => item.shopId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商家管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const shopId = row.shopId || this.ids
      getTz_shop_detail(shopId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商家管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.shopId != null) {
            updateTz_shop_detail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_shop_detail(this.form).then(response => {
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
      const shopIds = row.shopId || this.ids;
      this.$modal.confirm('是否确认删除商家管理编号为"' + shopIds + '"的数据项？').then(function() {
        return delTz_shop_detail(shopIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_shop_detail/export', {
        ...this.queryParams
      }, `tz_shop_detail_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
