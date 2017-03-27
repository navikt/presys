"use strict";

const path = require('path');
const HappyPack = require('happypack');

const APP_DIR = path.resolve(__dirname, 'src/client/app');
const IMG_DIR = path.resolve(__dirname, 'src/client/images');
const STYLE_DIR = path.resolve(__dirname, 'src/client/styles');

const config = {
	devtool: "eval",
	target: 'node', // webpack should compile node compatible code
	module : {
		rules : [{
			test : /\.jsx?$/,
			enforce : "pre",
			loader : 'eslint-loader',
			options : {
				failOnWarning : false,
				failOnError : true,
				configFile : './.eslintrc.test.js',
				fix : true,
			},
			include : APP_DIR,
			exclude : /node_modules/
		},
		{
			test : /\.jsx?$/,
			use : [	'happypack/loader' ],
			include : APP_DIR,
			exclude : /node_modules/
		},
		{
			test : /\.(less|jpg|png|svg)$/,
			loader : 'null-loader',
			exclude : /node_modules/
		}]
	},
	
	plugins : [ 
		new HappyPack({
			loaders: [ 'babel-loader?presets[]=es2015,presets[]=es2016,presets[]=es2017,presets[]=react' ],
			threads: 4
		}),
	],

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
