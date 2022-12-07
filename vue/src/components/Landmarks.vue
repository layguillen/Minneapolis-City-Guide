<template>
<div>
    <p>HELLO</p>
  <div v-for="landmark in this.$store.state.landmarks" v-bind:key="landmark.id">
      <p>{{landmark.description}}</p>
  </div>
</div>
</template>

<script>
import landmarkservice from '../services/LandmarkService';
export default {
    name: 'landmarks',
    created(){
        landmarkservice.list().then(response => {
            this.$store.commit('SET_LANDMARKS', response.data);
        })
    }
}
</script>

<style>

</style>