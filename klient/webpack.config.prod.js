"use strict";

const webpack = require('webpack');
const path = require('path');

const APP_DIR = path.resolve(__dirname, 'src/client/app');
const IMG_DIR = path.resolve(__dirname, 'src/client/images');
const STYLE_DIR = path.resolve(__dirname, 'src/client/styles');

const ExtractTextPlugin = require('extract-text-webpack-plugin');

const config = {
	devtool : 'cheap-module-source-map',
	entry : ['babel-polyfill',  APP_DIR + '/index.jsx' ],
	output : {
		path : path.join(__dirname, 'dist'),
		filename : 'bundle.js',
		publicPath : '/public/'
	},
	module : {
		rules : [ {
			test : /\.jsx?$/,
			enforce : "pre",
			loader : 'eslint-loader',
			options : {
				failOnWarning : false,
				failOnError : true,
				configFile : './.eslintrc.prod.js'
			},
			include : APP_DIR,
			exclude : /node_modules/
		}, {
			test : /\.jsx?$/,
			loader : 'babel-loader',
			options : {
				presets : ["react",[ "es2015", { "modules": false }], "es2016", "es2017", "stage-0" ]
			},
			include : APP_DIR,
			exclude : /node_modules/
		}, {
			test : /\.less$/,
			use : ExtractTextPlugin.extract({
				fallback : 'style-loader',
				use : [ {
					loader : 'css-loader',
					options : {
						importLoaders : 1,
						modules : true,
						localIdentName : '[name]_[local]_[hash:base64:5]'
					},
				}, {
                    loader : 'less-loader',
                    options : {
                        modules : true,
                        localIdentName : '[name]_[local]_[hash:base64:5]'
                    },
                } ],
			  }),
			include : [APP_DIR, STYLE_DIR]
		}, {
			test : /\.(jpg|png|svg)$/,
			loader : 'file-loader',
			options : {
				name : '/[name]_[hash].[ext]'
			},
			include : IMG_DIR
		} ]
	},

	plugins : [
	    new ExtractTextPlugin("style.css"),
	    new webpack.DefinePlugin({'process.env.NODE_ENV' : JSON.stringify(process.env.NODE_ENV)	}),
	    new webpack.LoaderOptionsPlugin({
	    	minimize: true,
	    	debug: false
	    }),
        new webpack.optimize.UglifyJsPlugin({
	    	beautify: false,
	    	comments: false,
	    	extractComments: false,
	    	compress: {
                warnings: false
            },
	    	mangle: true,
	    	sourceMap: false,
        })
	],

	stats: {
		children: false
	},

	resolve : {
		alias : {
			styles: STYLE_DIR,
			images: IMG_DIR,
			messages: path.resolve(__dirname, 'src/client/messages'),
			testHelpers: path.resolve(__dirname, 'src/client/test-helpers'),
			actions: APP_DIR + '/actions',
			components: APP_DIR + '/components',
			elements: APP_DIR + '/components/elements',
			constants: APP_DIR + '/constants',
			containers: APP_DIR + '/containers',
			reducers: APP_DIR + '/reducers',
			services: APP_DIR + '/services',
			helpers: APP_DIR + '/helpers',
		    ducks: APP_DIR + '/ducks',
		},
		extensions : [ '.json', '.js', '.jsx' ]
	},

	externals : {
		'cheerio' : 'window',
		'react/addons' : 'react',
		'react/lib/ExecutionEnvironment' : 'react',
		'react/lib/ReactContext' : 'react',
	},
};
module.exports = config;
