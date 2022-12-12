<template>
  <div id="pending-landmarks-container">
      <h3>Pending Landmarks</h3>
      <div id="pending-landmark" v-for="landmark in this.$store.state.pendingLandmarks" :key="landmark.id">
          <h3>{{landmark.name}}</h3>
          <p>{{landmark.type.name}}</p>
          <p>{{landmark.description}}</p>
          <p>{{landmark.address.street}}
              {{landmark.address.city}},
              {{landmark.address.state}}
              {{landmark.address.zip}}
          </p>
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
            landmarkService.list()
            .then((response) => {
                this.$store.commit("SET_PENDING_LANDMARKS", response.data);
            })
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