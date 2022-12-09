<template>
  <div id="itinerary-container">
      <h1>Your Itinerary</h1>
      <Map />
      <div id="landmarks" v-for="landmark in this.$store.state.itineraryLandmarks" v-bind:key="landmark.id">
          <div id="title-btn-container">
              <h2 id="landmark-name">{{ landmark.name }}</h2>
              <button id="removeBtn" v-on:click="removeFromItinerary(landmark.id)">Remove</button>
          </div>
          <div id="desc-img-container">
            <div id="img-container">
                <img id="landmark-img" :src="landmark.img_URL" alt="Landmark Img">
            </div>  
            <p id="landmark-description"> {{landmark.description}}</p>
          </div>
      </div>
  </div>
</template>

<script>
import Map from '../components/Map.vue'
export default {
    name: "itinerary-landmarks-lister",
    components: {
        Map
    },
    created() {
        this.$store.state.landmarks.forEach(element => {
            this.$store.commit('SET_ITINERARY_LANDMARK', element);
        });
    },
    deleted() {
        this.$store.commit('EMPTY_ITINERARY_LANDMARKS');
    },
    methods: {
        removeFromItinerary(id){
           this.$store.commit("REMOVE_ITINERARY_LANDMARK", id);
           alert("Landmark removed from itinerary");
        }
    }
}
</script>

<style>

#itinerary-container{
    border: 2px #129D8D solid;
    margin: 20px 30px;
    padding: 1%;
    border-radius: 42px;
}

h1{
    text-align: center;
    color: #004E64;
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

#landmarks{
    display: flex;  
    flex-direction: column;
    margin: 10px 10px;
    padding: 1%;
}

#title-btn-container{
    display: flex;
    justify-content: space-between;
}

#desc-img-container{
    display: flex;
    justify-content: space-between;
}

#landmark-img{
    padding: 2px;
    margin-right: 10px;
    height: 10rem;
}

#removeBtn{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    border: 5px solid;
    padding: 8px;
    background-color: #004E64;
    color: #F3FCED;
    border-radius: 12px;
}

#removeBtn:hover {
  cursor: pointer;
}

</style>