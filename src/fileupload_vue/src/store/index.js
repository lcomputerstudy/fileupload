import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    file:null
  },
  mutations: {
  },
  actions: {
    submitFile({commit},payload){
      // this.file = payload;
      console.log("actinos"+payload)
      let formData = new FormData();
      formData.append('file', payload);
      axios.post('http://localhost:9000/upload',
          formData,
          {
          headers: {
              'Content-Type': 'multipart/form-data',
             'Access-Control-Allow-Origin': '*'
          }
        }
      ).then(function(){
    console.log('SUCCESS!!');
  })
  .catch(function(){
    console.log('FAILURE!!');
  });
    }
  },
  modules: {
  }
})
