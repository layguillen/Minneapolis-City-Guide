<template>
  <div class="saved-itineraries-page">
      <h1>Itineraries</h1>
      <div class="landmark-status success" v-show="itineraryDeleted">Itinerary deleted.</div>
      <div class="itinerary-container" v-for="itinerary in this.$store.state.itineraries" :key="itinerary.id">
        <div class="title-remove-container" >
          <h2>Itinerary: {{counter(itinerary)}}</h2>
          <button class="delete-itinerary-btn" v-on:click="deleteItinerary(itinerary.id)">Delete Itinerary</button>
        </div>
        <div class="hotel-container">
          <h3 >Hotel: {{itinerary.hotel.name}}</h3>
          <p> Hotel Address: {{itinerary.hotel.address.street}}
                        {{itinerary.hotel.address.city}},
                        {{itinerary.hotel.address.state}}
                        {{itinerary.hotel.address.zip}}
          </p>
        </div>
        <div class="landmark-container" v-for="landmark in itinerary.landmarks" :key="landmark.id">
          <div class="img-div">
            <img v-bind:src="landmark.img_URL" alt="Landmark photo">
          </div>
          <div class="landmark-text-container">
            <h3>{{landmark.name}}</h3>
            <h5>Type: {{landmark.type.name}}</h5>
            <p>{{landmark.description}}</p>
            <p>Address: {{landmark.address.street}}
                        {{landmark.address.city}},
                        {{landmark.address.state}}
                        {{landmark.address.zip}}
            </p>
          </div>
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
        } else {
          alert("Itinerary was not deleted.")
        }
        this.reloadPage();
      })
    },
    counter(itinerary){
      let itineraries = this.$store.state.itineraries;
      return itineraries.indexOf(itinerary) + 1;
    },
    reloadPage(){
      window.location.reload();
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
  overflow: hidden;

  border-radius:7px;
  padding: 10px 40px;
  border: 2px #004E64 solid;
  margin: 10px 10px;
  color: #F3FCED;
  margin: 20px 50px;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';

  background-color: #004E64;

  box-shadow:  10px 10px 20px #bebebe,
             -10px -10px 20px #ffffff;
}

.title-remove-container{
  display: flex;
  justify-content: space-between;
}

.title-remove-container h2{
  /* text-decoration: underline; */
  color: #F3FCED;
}

.hotel-container{
  margin: 2px 50px;
}

.landmark-container{
  display: flex;
  gap: 3rem;
  flex-wrap: wrap;

  margin: 2px 50px;
  padding: 15px 1px;
  border-top: 1px solid;
}

.landmark-text-container{
 max-width: 900px;
}

.delete-itinerary-btn{
  border: 5px rgb(228, 96, 96) solid;
  padding: 8px;
  background-color: rgb(228, 96, 96);
  color: #F3FCED;
  border-radius: 12px;
  font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
}

.delete-itinerary-btn:hover{
  cursor: pointer;
}

.img-div{
  height: 300px;
}

.img-div img{
  height: 100%;
}

</style>