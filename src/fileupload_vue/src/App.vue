<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <!--  -->
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>FileUpload</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <div style="width:800px">
        <!-- <input type="file" id="file" ref="file" v-on:change="handleFileUpload()"/> -->
        <v-file-input id="file" ref="file" v-model="fileinput" v-on:change="submitFile(fileinput)"></v-file-input>
        <!-- <input type="file" id="file" ref="file" /> -->
        <!-- <v-btn @click="submitFile($refs.file.files[0])">Upload</v-btn> -->
        <br>
        <img src="/images/img.jpg"  width="100px" height="100px" />
      </div>
    </v-main>
  </v-app>
</template>

<script>

import {mapActions} from 'vuex'
  export default {
    data: () => ({ 
      drawer: null ,
      file: [],
      fileinput:null
    }),
    methods: {
    handleFileUpload(){
      this.file = this.$refs.file.files[0];
      console.log("this.file"+this.file)
    },
    //  submitFile(){
    //         let formData = new FormData();
    //         formData.append('file', this.file);
    //         axios.post('http://localhost:9000/upload',
    //             formData,
    //             {
    //             headers: {
    //                 'Content-Type': 'multipart/form-data',
    //                'Access-Control-Allow-Origin': '*'
    //             }
    //           }
    //         ).then(function(){
    //       console.log('SUCCESS!!');
    //     })
    //     .catch(function(){
    //       console.log('FAILURE!!');
    //     });
    //   },
  submitFile(payload) {
    console.log(payload)
     this.$store.dispatch('submitFile', payload)
  }
   }
}
</script>