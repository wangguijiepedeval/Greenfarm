<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品ID" prop="prodId">
        <el-input
          v-model="queryParams.prodId"
          placeholder="请输入商品ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="订单项ID" prop="orderItemId">
        <el-input
          v-model="queryParams.orderItemId"
          placeholder="请输入订单项ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="评论用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入评论用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="记录时间" prop="recTime">
        <el-date-picker clearable
          v-model="queryParams.recTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择记录时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="回复时间" prop="replyTime">
        <el-date-picker clearable
          v-model="queryParams.replyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择回复时间">
        </el-date-picker>
      </el-form-item>
      <!-- <el-form-item label="是否回复 0:未回复  1:已回复" prop="replySts">
        <el-input
          v-model="queryParams.replySts"
          placeholder="请输入是否回复 0:未回复  1:已回复"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="IP来源" prop="postip">
        <el-input
          v-model="queryParams.postip"
          placeholder="请输入IP来源"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评分" prop="score">
        <!-- ，0-5分 -->
        <el-input
          v-model="queryParams.score"
          placeholder="请输入评分，0-5分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="有用的计数" prop="usefulCounts">
        <el-input
          v-model="queryParams.usefulCounts"
          placeholder="请输入有用的计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="是否匿名" prop="isAnonymous">
        (1:是  0:否)
        <el-input
          v-model="queryParams.isAnonymous"
          placeholder="请输入是否匿名(1:是  0:否)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="是否匿名" prop="isAnonymous">
        <el-select v-model="queryParams.isAnonymous" placeholder="是否匿名" clearable>
          <el-option
            v-for="dict in dict.type.tz_comm_isanonymous"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="评价(0好评 1中评 2差评)" prop="evaluate">
        <el-input
          v-model="queryParams.evaluate"
          placeholder="请输入评价(0好评 1中评 2差评)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->

      <el-form-item label="评价" prop="evaluate">
        <el-select v-model="queryParams.evaluate" placeholder="评价等级" clearable>
          <el-option
            v-for="dict in dict.type.tz_comm_evaluate"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['Greenfarm:tz_prod_comm:add']"
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
          v-hasPermi="['Greenfarm:tz_prod_comm:edit']"
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
          v-hasPermi="['Greenfarm:tz_prod_comm:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_prod_comm:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_prod_commList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="评论ID" align="center" prop="prodCommId" fixed :show-overflow-tooltip="true"/>
      <el-table-column label="商品ID" align="center" prop="prodId" :show-overflow-tooltip="true"/>
      <!-- <el-table-column label="订单项ID" align="center" prop="orderItemId" /> -->
      <el-table-column label="评论用户ID" align="center" prop="userId" min-width="200" :show-overflow-tooltip="true"/>
      <el-table-column label="评论内容" align="center" prop="content" min-width="200" :show-overflow-tooltip="true"/>
      <el-table-column label="掌柜回复" align="center" prop="replyContent" :show-overflow-tooltip="true"/>
      <el-table-column label="记录时间" align="center" prop="recTime" width="180" >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="回复时间" align="center" prop="replyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.replyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="是否回复 0:未回复  1:已回复" align="center" prop="replySts" /> -->
      <el-table-column label="IP来源" align="center" prop="postip" :show-overflow-tooltip="true"/>
      <el-table-column label="评分" align="center" prop="score" />
      <!-- ，0-5分 -->
      <!-- <el-table-column label="有用的计数" align="center" prop="usefulCounts" /> -->
      <!-- <el-table-column label="晒图的json字符串" align="center" prop="pics" /> -->
      <!-- <el-table-column label="是否匿名" align="center" prop="isAnonymous" /> -->
      <!-- (1:是  0:否) -->
      <el-table-column label="是否匿名" align="center" prop="isAnonymous" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tz_comm_isanonymous" :value="scope.row.isAnonymous"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="评论状态" align="center" prop="status" /> -->
      <el-table-column label="评论状态" align="center" prop="status" >
      <template slot-scope="scope">
          <dict-tag :options="dict.type.tz_comm_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <!-- 是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1 -->
      <!-- <el-table-column label="评价(0好评 1中评 2差评)" align="center" prop="evaluate" /> -->
       <el-table-column label="评价" align="center" prop="evaluate" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tz_comm_evaluate" :value="scope.row.evaluate"/>
        </template>
      </el-table-column>
      <el-table-column  fixed="right" label="操作" align="center" class-name="small-padding fixed-width" width="120">
        <template slot-scope="scope">
          
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row,scope.index)"
            v-hasPermi="['Greenfarm:tz_prod_comm:view']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_prod_comm:edit']"
          >修改</el-button>
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_prod_comm:remove']"
          >删除</el-button> -->
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

    <!-- 添加或修改商品评论对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="商品ID" prop="prodId">
          <el-input v-model="form.prodId" placeholder="请输入商品ID" />
        </el-form-item>
        <el-form-item label="订单项ID" prop="orderItemId">
          <el-input v-model="form.orderItemId" placeholder="请输入订单项ID" />
        </el-form-item>
        <el-form-item label="评论用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入评论用户ID" />
        </el-form-item>
        <el-form-item label="评论内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="掌柜回复">
          <editor v-model="form.replyContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="记录时间" prop="recTime">
          <el-date-picker clearable
            v-model="form.recTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="回复时间" prop="replyTime">
          <el-date-picker clearable
            v-model="form.replyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择回复时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否回复 0:未回复  1:已回复" prop="replySts">
          <el-input v-model="form.replySts" placeholder="请输入是否回复 0:未回复  1:已回复" />
        </el-form-item>
        <el-form-item label="IP来源" prop="postip">
          <el-input v-model="form.postip" placeholder="请输入IP来源" />
        </el-form-item>
        <el-form-item label="评分" prop="score">
          <el-input v-model="form.score" placeholder="请输入得分，0-5分" />
        </el-form-item>
        <el-form-item label="有用的计数" prop="usefulCounts">
          <el-input v-model="form.usefulCounts" placeholder="请输入有用的计数" />
        </el-form-item>
        <el-form-item label="晒图的json字符串" prop="pics">
          <el-input v-model="form.pics" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <!-- <el-form-item label="是否匿名(1:是  0:否)" prop="isAnonymous">
          <el-input v-model="form.isAnonymous" placeholder="请输入是否匿名(1:是  0:否)" />
        </el-form-item> -->
        <el-form-item label="是否匿名" prop="isAnonymous">
          <el-radio-group v-model="form.isAnonymous">
            <el-radio
              v-for="dict in dict.type.tz_comm_isanonymous"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <!-- <el-form-item label="评价" prop="evaluate">
          <el-input v-model="form.evaluate" placeholder="请输入评价(0好评 1中评 2差评)" />
        </el-form-item> -->
        <!-- <el-form-item label="评论状态" prop="status">
          <el-input v-model="form.status" placeholder="评论状态" />
        </el-form-item> -->
        <el-form-item label="评论状态" prop="status">
              <el-tooltip :content="'Switch value: ' + form.status" placement="top">
                <el-switch 
                  v-model="form.status"
                  active-color="#13ce66"
                  inactive-color="#ff4949"
                  :active-value="1"
                  :inactive-value="-1"
                  active-text="显示"
                  inactive-text="撤消">
                </el-switch>                 
              </el-tooltip>
        </el-form-item>
        <el-form-item label="评价" prop="evaluate">
              <el-select v-model="form.evaluate" placeholder="请选择评价等级">
                <el-option
                  v-for="dict in dict.type.tz_comm_evaluate"
                  :key="dict.value"
                  :label="dict.label"
                  :value="parseInt(dict.value)"
                ></el-option>
              </el-select>
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
import { listTz_prod_comm, getTz_prod_comm, delTz_prod_comm, addTz_prod_comm, updateTz_prod_comm } from "@/api/Greenfarm/tz_prod_comm";

export default {
  name: "Tz_prod_comm",
  dicts: ['tz_comm_evaluate','tz_comm_isanonymous','tz_comm_status'], 
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
      // 商品评论表格数据
      tz_prod_commList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        prodId: null,
        orderItemId: null,
        userId: null,
        content: null,
        replyContent: null,
        recTime: null,
        replyTime: null,
        replySts: null,
        postip: null,
        score: null,
        usefulCounts: null,
        pics: null,
        isAnonymous: null,
        status: null,
        evaluate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        prodId: [
          { required: true, message: "商品ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
     /** 查看详细信息 */
     handleClick(row) {
        console.log(row);
      },
      handleView(row) {
      this.open = true;
      this.form = row;
    },
    /** 查询商品评论列表 */
    getList() {
      this.loading = true;
      listTz_prod_comm(this.queryParams).then(response => {
        this.tz_prod_commList = response.rows;
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
        prodCommId: null,
        prodId: null,
        orderItemId: null,
        userId: null,
        content: null,
        replyContent: null,
        recTime: null,
        replyTime: null,
        replySts: null,
        postip: null,
        score: null,
        usefulCounts: null,
        pics: null,
        isAnonymous: null,
        status: 0,
        evaluate: null
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
      this.ids = selection.map(item => item.prodCommId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品评论";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const prodCommId = row.prodCommId || this.ids
      getTz_prod_comm(prodCommId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品评论";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.prodCommId != null) {
            updateTz_prod_comm(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_prod_comm(this.form).then(response => {
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
      const prodCommIds = row.prodCommId || this.ids;
      this.$modal.confirm('是否确认删除商品评论编号为"' + prodCommIds + '"的数据项？').then(function() {
        return delTz_prod_comm(prodCommIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_prod_comm/export', {
        ...this.queryParams
      }, `tz_prod_comm_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
