import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {

        listLandmarkTypes() {
            return axios.get('/landmark/styles');
        },

        listLandmarks() {
            return http.get('/landmark/list');
        }
}