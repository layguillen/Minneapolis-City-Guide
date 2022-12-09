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

 <div class="buttons">

    <div class="addDiv">
      <a href="#" class="addButton" v-on:click="addToItinerary()">add to itinerary</a>
    </div>



    <div class="cancelDiv">
      <button class = "cancelButton">
        <router-link id= "reviewLink" :to="{ name: 'home' }">cancel</router-link>
      </button>
      </div>

        <div class = "reviewDiv">
        <button class = "reviewButton">
          <router-link id= "reviewLink" :to="{ name: 'NewReview' }">leave a review</router-link>
          </button>
      </div>
      
      <div class="likeDiv">
        <button class="likeButton" >Likes: {{this.$store.state.currentLandmark.likes}}</button>
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
   });
   },
   addToItinerary(){
     this.$store.commit('SET_ITINERARY_LANDMARK', this.$store.state.currentLandmark);
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

.addButton {
  
  margin-left:20px;
  padding:5px;
  border-radius: 20px;
  font-size: 30px;
  background-color:#BD92DD;
  color: #F3FCED;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';

}


.cancelButton {
  padding:5px;
  border-radius: 20px;
  margin-left:275px;

  font-size: 30px;
  background-color:#BD92DD;
  color: #F3FCED;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}


.reviewButton{
  background-color:#BD92DD;
  color: #F3FCED;
  border-radius:20px;
  padding:5px;
  margin-left: 395px;

  font-size: 30px;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';

}

.buttons{
  display: flex;
  justify-content: center;
  align-items: center;
  grid-area: footer;
}

#reviewLink{
  color: #F3FCED;
}
.titleDiv{
  grid-area:desc;
  display: inline-block;
 
  text-align:center;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
  font-size: 180%;
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
.likeButton{
  
  background-color:#BD92DD;
  color: #F3FCED;
  border-radius:20px;
  padding:5px;
  margin-left: 395px;

  font-size: 30px;
  border:none;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}


</style>