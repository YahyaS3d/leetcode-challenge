var debounce = function(fn, t) {
    let timer;

    return function (...args) {
        // Clear the previous timer if it exists
        if (timer) {
            clearTimeout(timer);
        }

        // Set a new timer to execute the function after t milliseconds
        timer = setTimeout(() => {
            fn(...args);
        }, t);
    };
};
const log = debounce((...inputs) => {
    console.log([Date.now() - start, inputs]);
}, 50);

let start = Date.now();
setTimeout(() => log(1), 50);
setTimeout(() => log(2), 75);
