const maxItems = 5;

let state = {step: "collect", collected:0, inventory: []};

const stepText = {
    collect: "Gather leaves and twigs.",
    plant: "You found a seed! Find a place to place it."
};

function getState(){
    return {...state, text: stepText[state.step]}
}

function doAction(action){
    let message = "";
}

if (action === "collect" && state.step === "collect"){
    state.collected++;
    message = "Collected ${state.collected} of ${maxItems}";
}

if (state.collected >= maxItems){
    state.inventory.push("seed");
    state.step = "plant";
    message = "You found a seed!";
} else if (action === "plant" && state.step === "plant"){
    state.invetory = state.inventory.filter(i => i !== "seed");
    state.step = water
} else if (action === "water" && state.step === "water"){
    state.step = "sleep";
} else if (action === "sleep" && state.step === "sleep"){
    state.step = "grown";
} else{
    message = "You can't do that right now.";
}

return {state: getState(), message};