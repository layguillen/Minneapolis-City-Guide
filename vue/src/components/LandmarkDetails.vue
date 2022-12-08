<template>
<div id = "mainDiv"> 
   <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>

    <!-- image -->
     <div class="griditem1">
       <img v-bind:src="this.$store.state.currentLandmark.img_URL" id="landmark1"/>
     </div>

     <!-- name -->
     <div class="griditem2">
       <h1>{{this.$store.state.currentLandmark.name}}</h1>
     </div>

     <!-- description-->
     <div class="griditem3">
      <p id = "description">{{this.$store.state.currentLandmark.description}}</p>
     </div>
    <div class="buttons">
     <div class = "addToItinerary">
    <button type="submit">
        add to itinerary
      </button>

      </div>
      <div class="cancelButton">
        <button>
          cancel
        </button>
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

#mainDiv{
  background-color:#004E64;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-areas: 
  "img desc"
  "buttons buttons";
  grid-template-rows: 1fr 1fr;
  height: 100vh;
  width: 100vw;
  margin:0px;
}

.griditem2{
  grid-area: desc;
  display: inline-block;
 
  text-align:center;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 150%;
  color:#F3FCED;
  text-decoration-line: underline;
  text-decoration-color: #F3FCED;
  text-underline-offset: 20px;
  text-align: center;
  margin-top: 7%;
  margin-left: 5%;
  
}
.griditem3{
  grid-area: desc;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 30px;
  color: #F3FCED;
  margin-top: 20%;
  margin-left:10%;

}

#landmark1 {
  grid-area: img;
  height: 70%;
  width: 100%;
  margin-left: 5vh;
  margin-top: 10vh;
  border-radius: 50px;
}

.addToItinerary {
  border-radius: 10px;
}
.cancelButton{
  border-radius: 10px;
  margin-left: 50px;
}
.buttons{
  grid-area: buttons;
  display: flex;
  margin-left: 50px;
}
</style>