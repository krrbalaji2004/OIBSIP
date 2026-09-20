function convert(){
    let input=document.querySelector("input").value;
    let unit=document.querySelector("select").value;

    let celsius=document.getElementById("cel");
    let farenhit=document.getElementById("faren");
    let kelvin=document.getElementById("kelvin");
    let error=document.getElementById("error");

    if(input===""){
        error.innerText="Please Enter temperature value";
        return;
    }
    let temperature=Number(input);
    if(unit==="Celsius"){
        let c=temperature;
        let f=(temperature*9/5)+32;
        let k=temperature+273.15;
        celsius.innerText="Celsius: "+c.toFixed(2)+" C";
        farenhit.innerText="Fahrenheit: "+f.toFixed(2)+" F";
        kelvin.innerText="Kevin: "+k.toFixed(2)+" K";
    }
    else if(unit==="Fahrenheit"){
        let c=(temperature-32)*5/9;
        let f=temperature;
        let k=c+273.15;
        celsius.innerText="Celsius: "+c.toFixed(2)+" C";
        farenhit.innerText="Fahrenheit: "+f.toFixed(2)+" F";
        kelvin.innerText="Kevin: "+k.toFixed(2)+" K";
    }
    else{
        let c=temperature-273.15;
        let f=(c*9/5)+32;
        let k=temperature;
        celsius.innerText="Celsius: "+c.toFixed(2)+" C";
        farenhit.innerText="Fahrenheit: "+f.toFixed(2)+" F";
        kelvin.innerText="Kelvin"+k.toFixed(2)+" K";
    }
    error.innerText="";
}