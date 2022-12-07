import axios from "axios";

export default {
    addReview(review){
        return axios.post('/review/new', review);
    }
}