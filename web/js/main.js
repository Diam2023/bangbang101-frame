window.onload = () => {
    var backgroundList = {
        "srcList": [
            {
                "name": "咖啡厅",
                "src": "./resources/backgrounds/咖啡厅.png"
            },
            {
                "name": "KTV包厢",
                "src": "./resources/backgrounds/KTV包厢.jpg"
            },
            {
                "name": "两个镜子的夕阳",
                "src": "./resources/backgrounds/两个镜子的夕阳.jpg"
            },
            {
                "name": "一个镜子的夕阳",
                "src": "./resources/backgrounds/一个镜子的夕阳.jpg"
            }
        ]
    }

    let imgList = backgroundList.srcList;
    run("data.json", imgList);
}