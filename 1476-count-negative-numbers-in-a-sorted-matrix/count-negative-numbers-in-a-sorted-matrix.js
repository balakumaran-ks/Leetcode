/**
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function(grid) {
    let count=0;
    for(let arr of grid){
        count+=arr.filter(el=>el<0).length;
    }
    return count;
};