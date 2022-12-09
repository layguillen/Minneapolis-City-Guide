<template>
  <div id="itinerary-landmarks">
      <h1>Landmarks</h1>
      <div id="landmarks" v-for="landmark in this.$store.state.itineraryLandmarks" v-bind:key="landmark.id">
          <!-- <img id="landmark-img" src="../assets/Landmark2.png" alt="Landmark Img"> -->
          <h2 id="landmark-name">{{ landmark.name }}</h2>
      </div>
  </div>
</template>

<script>
export default {
    name: "itinerary-landmarks-lister",
    created() {
        this.$store.state.landmarks.forEach(element => {
            this.$store.commit('SET_ITINERARY_LANDMARK', element);
        });
    },
    deleted() {
        this.$store.commit('EMPTY_ITINERARY_LANDMARKS');
    }
}
</script>

<style>

h1{
    text-align: center;
    color: #004E64;
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial', 'sans-serif';
}

</style>