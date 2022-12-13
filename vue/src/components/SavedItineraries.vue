<template>
  <div class="saved-itineraries-page">
      <h2>Itineraries</h2>
      <div class="landmark-status success" v-show="itineraryDeleted">Itinerary deleted.</div>
      <div class="itinerary-container" v-for="itinerary in this.$store.state.itineraries" :key="itinerary.id">
        <div class="title-remove-container">
          <h3>Itinerary Number: {{itinerary.id}}</h3>
          <button class="delete-itinerary-btn" v-on:click="deleteItinerary(itinerary.id)">Delete Itinerary</button>
        </div>
        <p v-bind:value="hotelId">Hotel ID: {{itinerary.hotel_id}}</p>
        <div class="landmark-container" v-for="landmark in itinerary.landmarks" :key="landmark.id">
          <h4>Landmark Name: {{landmark.name}}</h4>
          <h5>Type: {{landmark.type.name}}</h5>
          <p>{{landmark.description}}</p>
          <p>Address: {{landmark.address.street}}
                      {{landmark.address.city}},
                      {{landmark.address.state}}
                      {{landmark.address.zip}}
          </p>
          <img v-bind:src="landmark.img_URL" alt="Landmark photo">
          
        </div>
      </div>
  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService'

export default {
  name: 'saved-itineraries',
  data(){
    return {
      itineraryDeleted: false,
      hotelId: 0,
      hotelName: '',
      hotelAddress: ''
    }
  },
  created(){
    this.listItineraries();
    this.setHotel();
  },
  methods: {
    listItineraries(){
      ItineraryService.listItineraries()
      .then((response) => {
        this.$store.commit('SET_ITINERARIES', response.data);
      });
    },
    deleteItinerary(id){
      ItineraryService.removeItinerary(id)
      .then((response)=> {
        if(response.status === 200){
          this.itineraryDeleted = true;
          alert("Itinerary deleted. Status code 200");
        } else if (response.status === 201){
          this.itineraryDeleted = true;
          alert("Itinerary deleted. Status code 201")
        } else {
          alert("Itinerary was not deleted.")
        }
      })
    },
    setHotel(){
      if(this.hotelId === 1){
        this.hotelName = 'The Marquette Hotel, Curio Collection by Hilton';
        this.hotelAddress= '';
      } else if(this.hotelId === 2){
        this.hotelName = 'Hyatt Place Minneapolis/Downtown';
        this.hotelAddress= '';
      } else if(this.hotelId === 3){
        this.hotelName = 'Hewing Hotel';
        this.hotelAddress= '';
      }
    }
  }
}
</script>

<style>

.itinerary-container{
  display: flex;
  flex-direction: column;
  justify-content: left;
  align-items: left;

  border-radius:7px;
  padding: 10px;
  border: 2px #004E64 solid;
  margin: 10px 10px;

  color: #004E64;

  margin: 20px 50px;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

.title-remove-container{
  display: flex;
  justify-content: space-between;
}

.delete-itinerary-btn{
  border: 5px solid;
  padding: 8px;
  background-color: rgb(228, 96, 96);
  color: #F3FCED;
  border-radius: 12px;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

.delete-itinerary-btn:hover{
  cursor: pointer;
}

.landmark-container{
  margin: 20px 50px;
}

</style>