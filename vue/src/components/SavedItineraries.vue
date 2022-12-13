<template>
  <div>
      <h2>Itineraries</h2>
      <div class="itinerary-container" v-for="itinerary in this.$store.state.itineraries" :key="itinerary.id">
        <h3>{{itinerary.id}}</h3>
        <p>{{itinerary.userId}}</p>
        <div class="landmark-container" v-for="landmark in this.$store.state.itineraries.landmarks" :key="landmark.id">
          <h4>{{landmark.name}}</h4>
        </div>
      </div>
  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService'

export default {
  name: 'saved-itineraries',
  data(){

  },
  created(){
    this.listItineraries();
  },
  methods: {
    listItineraries(){
      ItineraryService.listItineraries()
      .then((response) => {
        this.$store.commit('SET_ITINERARIES', response.data);
      });
    },
  }
}
</script>

<style>

</style>