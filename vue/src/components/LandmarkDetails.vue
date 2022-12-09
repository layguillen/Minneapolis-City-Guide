<template>
<div class="mainDiv"> 

   <link rel="stylesheet" href='https://fonts.googleapis.com/css?family=Montserrat Alternates'>

    
     <div class="imgDiv">
       <img v-bind:src="this.$store.state.currentLandmark.img_URL" id="imgId"/>
     </div>

    
     <div class="titleDiv">
       <h1>{{this.$store.state.currentLandmark.name}}</h1>
     </div>

    
     <div class="descDiv">
      <p id = "description">{{this.$store.state.currentLandmark.description}}</p>
     </div>

    <div class="addDiv">
      <button class="addButton" type="submit">
        add to itinerary
      </button>
      </div>

    <div class="cancelDiv">
      <button class = "cancelButton" type="submit">
        cancel
      </button>
      </div>

        <div class = "newReview">
        <button class = "reviewButton">
          <router-link id= "reviewLink" :to="{ name: 'NewReview' }">leave a review</router-link>
          </button>
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
   });
   }
 },
 created(){
   this.setDetails();
 }
}
</script>

<style>

body{
  margin:0;
  padding:0;
}
.mainDiv{
  background-color:#004E64;

  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(2, 1fr);
  grid-template-areas: 
  "img desc"
  "footer footer";
  
  height: 100vh;
  width: 100vw;
}

#imgId{
  grid-area: img;
  height: 75%;
  width: 40vw;
  margin-left: 8vh;
  margin-top: 8vh;
  border-radius: 20%;
} 
.addDiv{
  grid-area:footer;
  border-radius: 20px;
  margin-left:20px;
}
.addButton {
  margin-top:22%;
  padding:5px;
  border-radius: 20px;
  font-size: 30px;
  background-color:#BD92DD;
  color: #F3FCED;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

.cancelDiv {
  grid-area: footer;
  margin-left:275px;
}
.cancelButton {
  padding:5px;
  border-radius: 20px;
  margin-top:419px;
  font-size: 30px;
  background-color:#BD92DD;
  color: #F3FCED;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}
.newReview {
 grid-area:footer;
  margin-left: 395px;
}

.reviewButton{
  background-color:#BD92DD;
  color: #F3FCED;
  border-radius:20px;
  padding:5px;
  margin-top:420px;
  font-size: 30px;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

#reviewLink{
  color: #F3FCED;
}
.titleDiv{
  grid-area:desc;
  display: inline-block;
 
  text-align:center;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 200%;
  color:#F3FCED;
  text-decoration-line: underline;
  text-decoration-color: #F3FCED;
  text-underline-offset: 20px;
  text-align: left;
  margin-top: 7%;
  margin-right: 10px;
  
}
.descDiv{
  grid-area: desc;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 30px;
  color: #F3FCED;
  margin-top: 20%;
  margin-left:0%;
  margin-right:10%;
}

#description {
  margin-bottom:-400px;
}

</style>