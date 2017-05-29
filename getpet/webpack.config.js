var path = require('path');

module.exports = {
    entry: './src/main/resources/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        loaders: [
        	{
        		test: /\.css$/,
        		exclude: /(node_modules)/,
        		loader: "style-loader!css-loader"
        	},
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};