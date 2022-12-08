import axios from "axios";

export default {
    addReview(review){
        return axios.post('/review/new', review);
    },
    listReviews(landmarkId){
        return axios.get(`/review/list/${landmarkId}`);
    }
}