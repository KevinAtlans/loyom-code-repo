(function () {
    var doc = document;
    var config = {
        COCOS2D_DEBUG:2, //0 to turn debug off, 1 for basic debug, and 2 for full debug
        box2d:false,
        chipmunk:false,
        showFPS:true,
        frameRate:60,
        loadExtension:false,
        tag:'gameCanvas', //the dom element to run cocos2d on
        engineDir:'../Cocos2D-for-HTML5/cocos2d/',
        appFiles:[
            'ressources/ressources.js',
            'ressources/appMain.js'
        ]
    };
    window.addEventListener('DOMContentLoaded', function () {
        var script = doc.createElement('script');
        if (config.SingleEngineFile && !config.engineDir) {
            script.src = config.SingleEngineFile;
        }
        else if (config.engineDir && !config.SingleEngineFile) {
            script.src = config.engineDir + 'platform/jsloader.js';
        }
        else {
            alert('You must specify either the single engine file OR the engine directory in "cocos2d.js"');
        }
        document.ccConfig = config;
        script.id = 'cocos2d';
        doc.body.appendChild(script);
    });
})();