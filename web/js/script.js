var headerList = {
    "headerList": [
        { "name": "鸫", "url": "./resources/header/鸫.png" },
        { "name": "鸫2", "url": "./resources/header/鸫2.png" },
        { "name": "鸫3", "url": "./resources/header/鸫3.png" },
        { "name": "日菜", "url": "./resources/header/日菜.jpg" },
        { "name": "纱夜", "url": "./resources/header/纱夜.png" },
        { "name": "纱夜2", "url": "./resources/header/纱夜2.png" },
        { "name": "羽泽太太", "url": "./resources/header/while.png" },
    ]
}
async function ts(element) {
    return new Promise(
        resolve => {
            setTimeout(() => {
                html2canvas(element, {
                    // useCORS: true, // 【重要】开启跨域配置
                    // allowTaint: false
                }).then(canvas => {
                    // var img = new Image();
                    // img.src = canvas.toDataURL("image/png");
                    document.body.appendChild(canvas);
                });
                resolve();
            }, 1000);
        }
    )
}

async function ns() {
    var el = document.getElementsByClassName("dialogue");
    for (let i = 0; i < el.length; i++) {
        const element = el[i];
        await ts(element);
    }
}
window.onload = () => {
    run();
    // setTimeout(() => {
    //     ns();
    // }, 50000);
}
async function run() {
    var listView = document.querySelector(".list");
    var ll = {
        "frameList": [
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "失算了，我没带吉他。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "纱夜同学，这不是录音棚，带乐器什么的显然不太现实吧……",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "说的也是，不过还是要趁这次训练增进音感……",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "（打断）仅仅如此吗？",
                "aside": [
                    "打断"
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "倒也……不是……（脸红）",
                "aside": [
                    "脸红"
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "人家说一起唱歌可以增进感情的呀。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "是……是吗……我也是今天才知道呢，哈哈……（脸红）",
                "aside": [
                    "脸红"
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "姐姐真的才知道吗？嗯？",
                "aside": [
                    null
                ]
            },
            {
                "type": "sceneDescription",
                "description": "（日菜同学……和纱夜同学……未免……太近了点……）"
            },
            {
                "type": "sceneDescription",
                "description": "想到这里，鸫自嘲地笑了笑，这不是她该考虑的范畴啊，人家不过是邀请了你一下，别自作多情了，去管不该管的事情只会让人厌烦的啊……"
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "那么，来点歌吧！首先是……诶？姐姐你怎么这么快就点了……",
                "aside": [
                    null
                ]
            },
            {
                "type": "sceneDescription",
                "description": "前奏"
            },
            {
                "type": "roleDialogue",
                "name": "鸫2",
                "section": "（疑惑）这……好像是Aftergrow的……",
                "aside": [
                    "疑惑"
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "是的。我对你们的了解还是有的，也想从你们的歌中多了解一些关于你们的东西。",
                "aside": [
                    null
                ]
            },
            {
                "type": "sceneDescription",
                "description": "鸫不敢相信地看着纱夜"
            },
            {
                "type": "sceneDescription",
                "description": "虽然她一次次告诉自己不要多想，但每当纱夜说出这种话，她真的忍不住多想。她能看得出来纱夜不喜欢她，她有属于自己的分寸感，知道纱夜说这句话时没有想那么多。可是，可是她也需要温暖啊……就，就胡思乱想一次吧……一次就够了……"
            },
            {
                "type": "sceneDescription",
                "description": "几首歌的时间过去，三人都沉浸在音乐的氛围之中，这时，电话铃声响起。"
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "（看了一眼手机）是学生会成员的电话。",
                "aside": [
                    "看了一眼手机"
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "鸫同学还真是辛苦呢。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "抱歉，我去接个电话。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "快点回来哦。",
                "aside": [
                    null
                ]
            },
            {
                "type": "soundItem",
                "soundName": "隂る思い",
                "around": "AROUND"
            },
            {
                "type": "sceneDescription",
                "description": "较长时间停顿"
            },
            {
                "type": "sceneDescription",
                "description": "开门声"
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "啊，鸫回来了。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "抱歉，学生会的工作费了些时间。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "没事，放假了工作还这么繁忙，我很理解你。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "没歌了吗？那我去点。",
                "aside": [
                    null
                ]
            },
            {
                "type": "soundItem",
                "soundName": "届かない恋",
                "around": "AROUND"
            },
            {
                "type": "sceneDescription",
                "description": "二人鼓掌声"
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "鸫同学唱歌这么好听的吗？",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "（激动）这完全是屈才了啊！",
                "aside": [
                    "激动"
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "（眼神有些迷离）哪有，承让了。",
                "aside": [
                    "眼神有些迷离"
                ]
            },
            {
                "type": "sceneDescription",
                "description": "……"
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "今天真是十分开心呢！",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "如果有机会的话下次也一起吧。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "可以啊！姐姐可是意犹未尽呢。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "这里确实挺不错的，以后可以常来。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "那改天再约？",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "日菜",
                "section": "好啊好啊！时候也不早了，我们回去吧。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "纱夜",
                "section": "哦，好，鸫同学再见。",
                "aside": [
                    null
                ]
            },
            {
                "type": "roleDialogue",
                "name": "鸫",
                "section": "再见。（笑）",
                "aside": [
                    "笑"
                ]
            }
        ]
    };
    var lineList = ll.frameList;
    var header;
    var name;
    for (let index = 0; index < lineList.length; index++) {
        let line = lineList[index];
        await new Promise(resolve => {
            if (line.type == "roleDialogue") {
                for (let i = 0; i < headerList.headerList.length; i++) {
                    const element = headerList.headerList[i];
                    if (element.name == line.name) {
                        header = element.url;
                    }
                };
                name = line.name;
                var dom = "<li class='sp'><div classqw='dialogue'><header><img src='" + header + "' crossorigin='anonymous' alt='header' class='header'></header><section><span class='name'>" + line.name + "</span><div class='frame'><img src='./resources/img/dialog.png' alt='dialogue' class='diasite'><span class='rotationtiao'>" + line.section + "</span></div></section></div></li>";
                listView.innerHTML = dom;
            } else if (line.type == "sceneDescription") {
                var dom = "<li class='sp'><div class='dialogue'><header><img src='" + header + "' alt='header' class='header'></header><section><span class='name'>" + name + "</span><div class='frame'><img src='./resources/img/dialog.png' alt='dialogue' class='diasite'><span class='rotationtiao'>" + line.description + "</span></div></section></div></li>";
                listView.innerHTML = dom;
            }
            var element = document.getElementsByClassName("dialogue ")[0];
            html2canvas(element).then(canvas => {
                // create doawnload event
                let url = canvas.toDataURL("image/png");
                document.body.appendChild(canvas);
                var a = document.createElement("a");
                var event = new MouseEvent("click");
                a.download = index;
                a.href = url;
                a.dispatchEvent(event);
                setTimeout(() => {
                    resolve();
                }, 500);
            });
        });
    }
}