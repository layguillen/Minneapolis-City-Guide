import axios from 'axios';

export default{
    listItineraries(){
        return axios.get('/itinerary/list');
    },
    getItinerary(id){
        return axios.get(`/itinerary/${id}`);
    },
    saveItinerary(itinerary, landmarks){
        return axios.post('/itinerary/new', itinerary, landmarks);
    },
    removeItinerary(id){
        return axios.delete(`/itinerary/${id}`);
    }
}