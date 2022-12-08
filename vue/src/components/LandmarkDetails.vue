<template>
<div> 
   <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>
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
body{
  background-color: #004E64
}
.container{
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-template-rows: repeat(2, 1fr);
  
}
.griditem1{
  display: flex;
}
.griditem2{
  display: inline-block;
  grid-column-start: 3;
  grid-column-end: 5;
  grid-row-start: 1;
  grid-row-end:2;

  text-align:center;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 150%;
  color:#F3FCED;
  text-decoration-line: underline;
  text-decoration-color: #F3FCED;
  
}
.griditem3{
  grid-column-start: 2;
  grid-column-end: 5;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 25px;
  color: #F3FCED;
  margin-top: 150px;
}


#landmark1 {
  height: 50vh;
  width: 200%;
  margin-left: 5vh;
  margin-top: 10vh;
}

</style>