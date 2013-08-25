define([
  'jquery',
  'underscore',
  'backbone',
  'models/posting/PostingModel'
], function($, _, Backbone, PostingModel){
  var PostingsCollection = Backbone.Collection.extend({
    model: PostingModel,
    
    initialize: function(){

      var posting0 = new ProjectModel('job', 'Cognizant','CS'); 
      var posting1 = new ProjectModel('job', 'Infosys', 'CS'); 
      var posting2 = new ProjectModel('job','Mahindra', 'Mechanical'); 
      var posting3 = new ProjectModel('news','Orissa Government','Any');
      var posting4 = new ProjectModel('other','any','Any');
      
     // this.add([posting0, posting1, posting2, posting3, posting4]);

    }

  });
 
  return PostingsCollection;
});