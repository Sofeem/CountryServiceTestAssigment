import React, {useEffect} from 'react'
import CountriesCodeService from '../Service/CountriesCodeService';
import axios from "axios";

const CountriesCode = () => {
    const fetchCountryProfiles = () => {
        axios.get("http://localhost:8081/countries").then(res =>{
            console.log(res);
        });
    };
    useEffect(() =>{
        fetchCountryProfiles();

    },[]);
    return <h1>Hello</h1>
}

export default CountriesCode
