<template>
  <div>
    <div align="center" justify="center">
      <v-card width="1000" style="margin: 40px;">
        <v-card-title>
          <label style="margin-bottom: 30px;margin-left: 20px;">ตารางเเสดงผลการลงทะเบียนเรียน</label>
          <v-spacer></v-spacer>
          <v-text-field
            v-model="field_search"
            append-icon="fas fa-search"
            label="ค้นหาชื่อนักเรียน"
            solo
            rounded
            @keyup.enter.native="getEmployeeByEmployeeFullname"
          ></v-text-field>
        </v-card-title>

        <v-simple-table>
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">เลขที่</th>
                <th class="text-left">คำนำหน้าชื่อ</th>
                <th class="text-left">ชื่อ-นายสกุล</th>
                <th class="text-left">เพศ</th>
                <th class="text-left">ตำแหน่ง</th>
                <th class="text-left">ที่อยู่</th>
                <th class="text-left">จังหวัด</th>
                <th class="text-left">อีเมลล์</th>
                <th class="text-left">เวลาที่บันทึก</th>
              </tr>
            </thead>

            <tbody v-if="view.data">
              <tr v-for="item in employee" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.nametitle.nametitle }}</td>
                <td>{{ item.fullname }}</td>
                <td>{{ item.gender.gender }}</td>
                <td>{{ item.position.position }}</td>
                <td>{{ item.address}}</td>
                <td>{{ item.province.province}}</td>
                <td>{{ item.email }}</td>
                <td>{{ item.recorddate }}</td>
              </tr>
            </tbody>

            <tbody v-if="view.loading">
              <tr v-if="view.loading">
                <td colspan="11">
                  <v-text-field color="rgb(24,103,193)" loading disabled></v-text-field>
                </td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
        <v-divider></v-divider>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            text
            color="rgb(24,103,193)"
            style="margin-right: 20px;"
            @click="getEmployeeAll"
          >view all</v-btn>
          <Label style="margin-right: 20px;">Rows all page: {{ employee.length }}</Label>
        </v-card-actions>
      </v-card>
    </div>
  </div>
</template>

<script>
import http from "../../http-common";
export default {
  name: "ViewEmployee",
  data() {
    return {
      view: {
        data: false,
        loading: false
      },
      field_search: "",
      employee: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    getEmployeeByEmployeeFullname() {
      this.view.data = false;
      this.view.loading = true;

      http
        .get("/employee/" + this.field_search.trim() + "/")
        .then(response => {
          this.employee = response.data;
          console.log(this.employee);

          this.view.loading = false;
          this.view.data = true;
        })
        .catch(e => {
          console.log(e);

          this.view.loading = false;
          this.view.data = true;
        });
    },
    getEmployeeAll() {
      this.view.data = false;
      this.view.loading = true;

      http
        .get("/employee")
        .then(response => {
          this.employee = response.data;
          console.log(this.employee);

          this.view.loading = false;
          this.view.data = true;
        })
        .catch(e => {
          console.log(e);

          this.view.loading = false;
          this.view.data = true;
        });
    }
  },
  mounted() {
    this.getEmployeeAll();
  }
};
</script>
