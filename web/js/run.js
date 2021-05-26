async function run(dataUrl, imgList) {
    lineList = (await (await fetch(dataUrl)).json()).frameList;

    // roleDialogueDelay 为一个角色对话完全显示完后等待的时间
    var roleDialogueDelay = 1300;
    // roleDialogueinterval 为角色对话中每个字停留到下一个字显示的等待时间
    var roleDialogueinterval = 20;
    // roleDialogueRate 为倍率参数，对字数过长时的显示时间产生影响。
    var roleDialogueRate = 1.4;
    // frameSceneDelay 背景切换所用的时间为此参数的两倍
    var frameSceneDelay = 1000;
    // sceneDescriptionDelay 为单文段显示完成后的等待时间，就是单行括号的文字。
    var sceneDescriptionDelay = 1500;
    // sceneDescriptionInterval 为单文段中每个字停留到下一个字显示的等待时间
    var sceneDescriptionInterval = 30;
    // roleDialogueRate 为倍率参数，对字数过长时的显示时间产生影响。
    var sceneDescriptionRate = 1.8;
    // *以上单位均为毫秒

    for (let index = 0; index < lineList.length; index++) {
        let line = lineList[index];
        switch (line.type) {
            case "frameScene":
                let src;
                imgList.forEach(img => {
                    if (img.name == line.background) {
                        src = img.src;
                    }
                });
                await showFrameScene(src, frameSceneDelay);
                break;
            case "roleDialogue":
                await showRoleDialogue(line.name, line.section, roleDialogueDelay, roleDialogueinterval, roleDialogueRate);
                break;
            case "sceneDescription":
                await showSceneDescription(line.description, sceneDescriptionDelay, sceneDescriptionInterval, sceneDescriptionRate);
                break;
            default:
                console.log("ignor: " + line);
                break;
        }
    }
}