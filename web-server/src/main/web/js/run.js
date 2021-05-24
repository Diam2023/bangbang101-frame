async function run(lineList) {
    var roleDialogueDelay = 2000;
    var roleDialogueinterval = 20;
    var roleDialogueRate = 1.2;
    var frameSceneDelay = 1000;
    var sceneDescriptionDelay = 2500;
    var sceneDescriptionInterval = 30;
    var sceneDescriptionRate = 1.8;

    // await showFrameScene("C:\\Users\\asu\\Downloads\\83a394c9ba1642e082dbcecb2bc138c2.jpg");
    for (let index = 0; index < lineList.length; index++) {
        let line = lineList[index];
        switch (line.type) {
            case "frameScene":
                // await showFrameScene(line.background);
                await showFrameScene("C:\\Users\\asu\\Downloads\\83a394c9ba1642e082dbcecb2bc138c2.jpg", frameSceneDelay);
                break;
            case "roleDialogue":
                if (line.aside[0] != null) {
                    await showRoleDialogue(line.name, line.section + "（" + line.aside[0] + "）", roleDialogueDelay, roleDialogueinterval, roleDialogueRate);
                } else {
                    await showRoleDialogue(line.name, line.section, roleDialogueDelay, roleDialogueinterval, roleDialogueRate);
                }
                break;
            case "sceneDescription":
                await showSceneDescription(line.description, sceneDescriptionDelay, sceneDescriptionInterval, sceneDescriptionRate);
                break;
            default:
                console.warn("ignor: " + line);
                break;
        }
    }
}