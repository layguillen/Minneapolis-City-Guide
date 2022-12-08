<template>
  <div class="container">
    <!-- image -->
     <div class="griditem1">
       <img id = "landmark1" src="../assets/Landmark1.png" alt="">
     </div>
     <!-- name -->
     <div class="griditem2">
       <h1>{{this.$store.state.currentLandmark.name}}</h1>
     </div>
     <!-- description-->
     <div class="griditem3">
      <p id = "description">{{this.$store.state.currentLandmark.description}}</p>
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
  grid-template-rows: repeat(4, 1fr);
  background-color: #004E64
}
.griditem1{
  
}
/*
@font-face {
  font-family: Montserrat_Alternates;
  src: url(montserrat_alternate;);
}*/ 
.griditem2{
  grid-column-start: 2;
  grid-column-end: 6;
  grid-row-start: 1;
  grid-row-end:2;
  text-align:center;
  margin-top: 20px;
  font-family: fantasy;
  font-size: 200%;
  color:whitesmoke;
  text-decoration-line: underline;
  text-decoration-color: whitesmoke;
  text-underline-offset: 20px ;
  
}
.griditem3{
  grid-column-start:2;
  grid-column-end: 6;
  grid-row-start: 1;
  margin-left:25px;
  font-family:fantasy;
  font-size: 30px;
  color: whitesmoke;
  margin-top: 150px;
}

#description{
}

#landmark1 {
  width: 700px;
  height: 400px;
  margin-top: 60px;
  margin-left: 70px;
  float: left;
}

</style>