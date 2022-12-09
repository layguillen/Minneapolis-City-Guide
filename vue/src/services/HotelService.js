import axios from 'axios';

export default{
    listHotels(){
        return axios.get('/hotel/list');
    }
}