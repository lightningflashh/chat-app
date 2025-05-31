export interface User {
    id?: string,
    username?: string,
    password?: string,
    status?: Status,
    avatarUrl?: string,
}

export enum Status {
    ONLINE = 'ONLINE',
    OFFLINE = 'OFFLINE'
}
