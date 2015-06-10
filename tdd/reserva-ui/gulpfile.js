var gulp = require('gulp');
var serve = require('gulp-serve');


gulp.task('serve', serve(['app','templates','bower_components']));
