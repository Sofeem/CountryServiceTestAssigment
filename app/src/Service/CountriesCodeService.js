import axios from 'axios';

const EMPLOYEE_API_BASE_URL = 'http://localhost:8081/countries';

class CountriesCodeService{
    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
}
export default new CountriesCodeService();