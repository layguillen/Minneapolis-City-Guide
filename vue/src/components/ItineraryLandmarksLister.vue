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
      <div id="hotel-selection">
          <label for="hotel-search">Hotel</label>
          <select class="hotel-search" id="hotel-search" v-model="id" v-on:click="retrieveCurrentHotel">
              <option value="">--- Select your hotel ---</option>
              <option value="1">The Marquette Hotel</option>
              <option value="2">Hyatt Place Minneapolis/Downtown</option>
              <option value="3">Hewing Hotel</option>
              <option value="4">Hotel Ivy</option>
              <option value="5">The Westin Minneapolis</option>
              <option value="6">Hyatt Regency Minneapolis</option>
              <option value="7">Millennium Minneapolis</option>
              <option value="8">Aloft Minneapolis</option>
              <option value="9">Radisson RED Minneapolis Downtown</option>
              <option value="10">Hilton Minneapolis</option>
              <option value="11">The Royal Sonesta Minneapolis Downtown</option>
              <option value="12">Four Seasons Hotel Minneapolis</option>
              <option value="13">Minneapolis Marriott City Center</option>
              <option value="14">Embassy Suites by Hilton Minneapolis Downtown</option>
              <option value="15">Graduate Minneapolis</option>
              <option value="16">Moxy Minneapolis Uptown</option>
              <option value="17">Rand Tower Hotel, Minneapolis</option>
              <option value="18">Hyatt Centric Downtown Minneapolis</option>
              <option value="19">The Foshay</option>
              <option value="20">Renaissance Minneapolis Hotel</option>
              <option value="21">Hampton Inn & Suites Minneapolis/Downtown</option>
          </select>
          <div id="current-hotel-container" v-if="hotelSelected">
            <h4>{{this.$store.state.currentHotel.name}}</h4>
            <p>{{this.$store.state.currentHotel.address.street}}
                {{this.$store.state.currentHotel.address.city}},
                {{this.$store.state.currentHotel.address.state}}
                {{this.$store.state.currentHotel.address.zip}}
            </p>  
         </div>
      </div>
      <div id="delete-btn-container">
          <button id="deleteBtn" v-on:click="deleted()">Delete Itinerary</button>
      </div>
  </div>
</template>

<script>
 import Map from '../components/Map.vue'
import HotelService from '../services/HotelService'

export default {
    name: "itinerary-landmarks-lister",
    components: {
         Map
    },
    data(){
        return {
            id: "",
            hotelSelected: false
        }
    },
    created() {
        this.retrieveHotels();
    },
    methods: {
        removeFromItinerary(id){
           this.$store.commit("REMOVE_ITINERARY_LANDMARK", id);
           alert("Landmark removed from itinerary");
        },
        deleted() {
            this.$store.commit('EMPTY_ITINERARY_LANDMARKS');
            alert("Itinerary deleted");
            this.id = ""
        },
        retrieveHotels(){
            HotelService.listHotels()
            .then((response)=> {
                this.$store.commit("SET_HOTELS", response.data);
            })
        },
        retrieveCurrentHotel(){
            HotelService.getHotel(this.id)
            .then((response)=>{
                this.$store.commit("SET_CURRENT_HOTEL", response.data)
            });
            this.hotelSelected = true;
        }
    },
    
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

#landmark-description{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    color: #004E64;
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

#hotel-selection{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    text-align: center;
    margin-top: 5%;
    color: #004E64;
}

#delete-btn-container{
    display: flex;
    justify-content: center;
    align-items: center; 
}

#deleteBtn{
    font-family: 'Montserrat Alternates', 'Franklin Gothic Medium', 'Arial Narrow', 'Arial';
    border: 5px solid;
    padding: 8px;
    background-color: #004E64;
    color: #F3FCED;
    border-radius: 12px;
    margin-top: 10px;
}

#deleteBtn:hover{
    cursor: pointer;
}

</style>