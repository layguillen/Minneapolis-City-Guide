<template>
<div id="landmark-list">
  <p>LANDMARKS</p>
  <div v-for="landmark in this.$store.state.landmarks" v-bind:key="landmark.id">
      <div id="landmark-container">
          <h3>{{landmark.name}}</h3>
          <img src="" alt="landmark picture">
          <p>{{landmark.description}}</p>
      </div>
  </div>
</div>
</template>

<script>
import landmarkService from '../services/LandmarkService';

export default {
    name: 'landmarks',
    created(){
        this.retrieveLandmarks();
    },
    methods: {
        retrieveLandmarks() {
            landmarkService.list()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
            })
        }
    }
}
</script>

<style>


</style>