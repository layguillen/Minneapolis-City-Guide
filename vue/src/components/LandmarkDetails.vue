<template>
  <div class="container">
     <div class="griditem1">
       <img src="../assets/Landmark1.png" alt="">
     </div>
     <div class="griditem2">
       <h1>{{this.$store.state.currentLandmark.name}}</h1>
     </div>
     <div class="griditem3">
       <p>{{this.$store.state.currentLandmark.description}}</p>
     </div>
  </div>
</template>

<script>
import landmarkservice from '../services/LandmarkService.js'
export default {
 name: 'landmark-details',
 methods:{
   setDetails(){
     landmarkservice.getDetails(this.$route.params.id).then((response) =>{
     
    this.$store.commit('SET_LANDMARK', response.data);
   }).catch((error) =>{
     if(error.response.status === 404){
       console.log('didnt work');
     }
   })
   }
 },
 created(){
   this.setDetails();
 }
}
</script>

<style>

.container{
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(3, 1fr);
}
.griditem1{
  
}
.griditem2{
  grid-column-start: 4;
  grid-column-end: 5;
}
.griditem3{
  grid-column-start: 1;
  grid-column-end: 2;

}

</style>