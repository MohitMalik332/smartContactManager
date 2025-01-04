let currentTheme = getTheme();
//This will run whenever the project starts

document.addEventListener("DOMContentLoaded", () => {
    changeTheme(); //we are calling this function once the page is fully loaded.
})

function changeTheme() {
    //set to web page
    
    changePageTheme(currentTheme, ""); //pass current and old theme, in begining we have only current theme.

    //set the eventListner to change theme button
    const changeThemeButton = document.querySelector("#themeChangeButton");

    changeThemeButton.addEventListener("click", (event) => {
        let oldTheme = currentTheme;
        if (currentTheme === "dark"){
            currentTheme = "light";
        } else {
            currentTheme = "dark";
        };

        changePageTheme(currentTheme, oldTheme);
    });
};

// set theme to local Storage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}

// get theme from local Storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme){
    //now update the theme in local storage.
    setTheme(currentTheme);

    //remove the old theme from web pages
    if(oldTheme){
        document.querySelector("html").classList.remove(oldTheme);
    }

    //set the current theme on web pages
    document.querySelector("html").classList.add(theme);

    //change the text of button
    document.querySelector('#themeChangeButton').querySelector("span").textContent = 
    theme == "light" ? "Dark" : "Light";
}