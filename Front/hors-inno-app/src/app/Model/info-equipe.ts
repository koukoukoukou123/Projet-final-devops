import {Iteam} from './team';
import { Ichampionship } from './championship';
export interface IequipeInfo {
    championship ?: Ichampionship;
    teamName ?: Iteam;
    points ?: number;
    win ?: number;
    lose ?: number;
    draw ?: number;
}
