<template>
  <div id="pending-landmarks-container">
      <h3>Pending Landmarks</h3>
      <div id="" v-for="landmark in this.$store.state.pendingLandmarks" :key="landmark.name">

      </div>
  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService'

export default {
    created() {
        this.listPendingLandmarks();
    },
    methods: {
        listPendingLandmarks() {
            return this.$store.state.pendingLandmarks;
        },
        addLandmarkToDb(){
            landmarkService.addLandmark();
        }
    }
}
</script>

<style>

#pending-landmarks-container{
    border-top: #1fd6c1 5px solid;
    color: #004E64;
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

</style>