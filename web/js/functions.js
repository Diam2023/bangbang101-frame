/**
 * to show dialogue of ui
 * 
 * @param {string} name role name
 * @param {string} text role say text
 * @param {number} delay delay time to over dialogue after all text show {ms}
 * @param {number} interval interval of betwen two words show speed {ms}
 * @param {number} rate 倍率参数，对字数过长时的显示时间产生影响。
 * @returns {Promise} new Promise resolve to use await
 */
let showRoleDialogue = (name, text, delay = 1500, interval = 40, rate = 1) => {
    return new Promise(
        resolve => {
            let nameDom = document.querySelector(".name");
            let textDom = document.querySelector(".text");
            document.getElementsByTagName("section")[0].style.opacity = 1;
            nameDom.style.opacity = 1;
            nameDom.innerHTML = name;
            textDom.innerHTML = null;

            let textArray = text.split("");
            var i = 0;

            textArray.forEach(element => {
                i++;
                setTimeout(() => {
                    textDom.innerHTML = textDom.innerHTML + element;
                }, i * interval);
            });
            setTimeout(() => {
                resolve('done');
            }, (textArray.length * interval + delay) * rate);
        }
    )
}

/**
 * to change scene
 * 
 * @param {string} path img name
 * @param {number} delay delay time
 * @returns 
 */
let showFrameScene = (path, delay = 1000) => {
    return new Promise(resolve => {
        let element = document.querySelector(".background");
        hideElement(element, delay);
        setTimeout(() => {
            element.setAttribute("src", path);
            showElement(element, delay);
            setTimeout(() => {
                resolve();
            }, delay);
        }, delay);
    });
}

/**
 * to show scene description
 * 
 * @param {string} description scene description
 * @param {number} delay delay time to over dialogue after all text show {ms}
 * @param {number} interval interval of betwen two words show speed {ms}
 * @param {number} rate 倍率参数，对字数过长时的显示时间产生影响。
 * @returns {Promise} new Promise resolve to use await
 */
let showSceneDescription = (description, delay = 1000, interval = 60, rate = 1) => {
    return new Promise(resolve => {
        let nameDom = document.querySelector(".name");
        let textDom = document.querySelector(".text");
        document.getElementsByTagName("section")[0].style.opacity = 1;
        nameDom.style.opacity = 0;
        textDom.innerHTML = null;

        let textArray = description.split("");
        var i = 0;

        textArray.forEach(element => {
            i++;
            setTimeout(() => {
                textDom.innerHTML = textDom.innerHTML + element;
            }, i * interval);
        });
        setTimeout(() => {
            resolve('done');
        }, (textArray.length * interval + delay) * rate);
    })
}

function showElement(element, time = 1000, _type = "feed") {
    let feedIn = [
        { opacity: 0 },
        { opacity: 1 }
    ];
    element.style.display = 'block';
    runAnimation(element, feedIn, time);
}

function hideElement(element, time = 1000, _type = "feed") {
    let feedOut = [
        { opacity: 1 },
        { opacity: 0 }
    ];
    runAnimation(element, feedOut, time);
}

function runAnimation(element, animate, duration, easing = "ease", iterations = 1, delay = 0) {
    setTimeout(() => {
        let animationOption = {
            duration: duration,
            iterations: iterations,
            easing: easing
        };
        element.animate(animate, animationOption);
    }, delay);
}
