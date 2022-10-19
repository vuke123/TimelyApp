export class WorkSession {
    constructor(project: string, start: string, stop: string, duration: string) {
    }
    project!: string;
    start!: string;
    stop!: string;
    duration!: string;
    /*public getStart(): string {
        var date = (this.start.split('T')[0]).split('-');
        var realDate = date[2] + "." + date[1] + "." + date[0]; 
        var time = (this.start.split('T')[1]).split(':');
        var realTime = time[0] + ":" + time[1];
        var returnString = realDate + " " + realTime;
        return returnString;
    } 
    */
}

