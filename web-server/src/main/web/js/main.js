window.onload = () => {
    var jsonData = {
        "frameList": [            
            {
                "name": "monoliths",
                "section": "这是一段测试文字！"
            },
            {
                "name": "策划",
                "section": "稿子怎么还不出？（质问）"
            },
            {
                "name": "monoliths",
                "section": "...（沉默）"
            },
            {
                "name": "monoliths",
                "section": "快了快了...（汗）"
            }
        ]
    };

    let textList = jsonData.frameList;
    run(textList);
}

async function run(lineList) {
    for (let index = 0; index < lineList.length; index++) {
        let name = lineList[index].name;
        let section = lineList[index].section;
        await showText(name, section);
        console.log("s");
    }
}

let showText = (name, text, delay = 100, interval = 100) => {
    return new Promise(
        resolve => {
            console.log("say" + name);
            let nameDom = document.querySelector(".name");
            nameDom.innerHTML = name;
            let textDom = document.querySelector(".text");
            textDom.innerHTML = null;
            setTimeout(() => {
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
                }, i * interval + (delay) + 250 * i);
            }, delay);
        }
    )
}